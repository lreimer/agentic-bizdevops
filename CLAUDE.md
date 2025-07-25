# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## Project Overview

This is a demo repository for exploring agentic AI development use cases in BizDevOps, featuring a Quarkus-based Java application with Kubernetes deployment via GitOps.

## Key Commands

### Development
- `./gradlew quarkusDev` - Run application in development mode with live coding
- `./gradlew build` - Build the application
- `./gradlew test` - Run tests
- `./gradlew jacocoTestReport` - Generate test coverage reports

### Infrastructure
- `make prepare-gcp` - Configure GCP settings
- `make create-gcp-cluster` - Create GKE cluster
- `make bootstrap-gcp-flux2` - Bootstrap Flux GitOps
- `make delete-gcp-cluster` - Delete GKE cluster

## Architecture

### Technology Stack
- **Java 21** with **Quarkus 3.23.0** framework
- **Gradle** for build management
- **REST APIs** using Jakarta RESTful Web Services with Jackson
- **JUnit 5** and **REST Assured** for testing
- **Docker** containerization with multiple Dockerfile variants (JVM, native, legacy-jar, native-micro)

### Project Structure
- `src/main/java/dev/kernelkaput/ai/` - Main application code
- `src/test/java/` - Unit tests
- `src/native-test/java/` - Native compilation tests
- `infra/application/` - Kubernetes manifests using Kustomize
- `infra/cluster/` - Flux GitOps configuration
- `docs/` - Documentation including ADRs and Arc42 architecture docs

### Deployment Architecture
- **GitOps** with Flux for continuous deployment
- **Kustomize** for Kubernetes manifest management
- Base manifests in `infra/application/base/`
- Environment overlays in `infra/application/overlays/`
- GKE cluster deployment targeting `cloud-native-experience-lab` project

## MCP Integrations

The project demonstrates integration with multiple MCP (Model Context Protocol) servers:
- **GitHub MCP Server** - For issue management and repository operations
- **Google Cloud MCP Server** - For GKE cluster operations
- **Flux Operator MCP** - For GitOps workflow management
- **kagent.dev** - For Kubernetes API interactions

## Code Conventions

- Use Java 21 language features
- Follow Quarkus development patterns
- REST endpoints in `*Resource.java` classes
- Configuration in `application.properties`
- Use Jakarta annotations for REST and dependency injection
- Write tests for all REST endpoints using REST Assured