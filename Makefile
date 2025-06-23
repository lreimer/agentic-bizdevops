GCP_PROJECT ?= cloud-native-experience-lab
GCP_REGION ?= europe-north1
GCP_ZONE ?= europe-north1-b

GITHUB_USER ?= lreimer
CLUSTER_NAME ?= agentic-bizdevops

prepare-gcp:
	@gcloud config set project $(GCP_PROJECT)
	@gcloud config set compute/zone $(GCP_ZONE)
	@gcloud config set container/use_client_certificate False

create-gcp-cluster:
	@gcloud container clusters create $(CLUSTER_NAME)  \
	  	--release-channel=regular \
		--cluster-version=1.32 \
  		--region=$(GCP_REGION) \
		--addons HttpLoadBalancing,HorizontalPodAutoscaling \
		--workload-pool=$(GCP_PROJECT).svc.id.goog \
		--enable-autoscaling \
		--num-nodes=1 \
		--min-nodes=1 --max-nodes=3 \
		--machine-type=e2-standard-8 \
		--logging=SYSTEM \
    	--monitoring=SYSTEM
	@kubectl create clusterrolebinding cluster-admin-binding --clusterrole=cluster-admin --user=$$(gcloud config get-value core/account)
	@kubectl cluster-info

bootstrap-gcp-flux2:
	@flux bootstrap github \
		--owner=$(GITHUB_USER) \
        --repository=agentic-bizdevops \
        --branch=main \
        --path=./infra/cluster/$(CLUSTER_NAME) \
		--components-extra=image-reflector-controller,image-automation-controller \
		--read-write-key

delete-gcp-cluster:
	@gcloud container clusters delete $(CLUSTER_NAME) --region=$(GCP_REGION) --async --quiet