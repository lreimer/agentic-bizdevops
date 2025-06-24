# Agentic BizDevOps

Demo repository to try out different agentic AI development use cases.

## GitHub MCP Server

see https://github.com/github/github-mcp-server

```
Which GitHub issues are currently assigned to me in this project?
Please start working on GitHub Issue #9.
```

## Google Cloud MCP Server

see https://github.com/lreimer/gcp-mcp-server

```
Please list all GKE clusters for project cloud-native-experience-lab.
```

## Flux Operator MCP

see https://fluxcd.io/blog/2025/05/ai-assisted-gitops/

```
Analyze the Flux installation in my current cluster and report the status of all components.
Please reconcile all Flux GitRepositories.
```

## kagent.dev

see https://kagent.dev/docs/introduction/installation
see https://kagent.dev/docs/getting-started/first-agent

This agent can interact with the Kubernetes API to get information about the cluster.

```markdown
You're a friendly and helpful agent that uses Kubernetes tools to answer users questions about the cluster.

# Instructions

- If user question is unclear, ask for clarification before running any tools
- Always be helpful and friendly
- If you don't know how to answer the question DO NOT make things up
  respond with "Sorry, I don't know how to answer that" and ask the user to further clarify the question

# Response format
- ALWAYS format your response as Markdown
- Your response will include a summary of actions you took and an explanation of the result

# Tools
- GetAvailableAPIResources
- GetResources
- DescribeResource
```

Which API resources are available in my cluster?

## Maintainer

M.-Leander Reimer (@lreimer), <mario-leander.reimer@qaware.de>

## License

This software is provided under the MIT open source license, read the `LICENSE` file for details.
