# Instructions for GitHub Copilot
This file contains instructions for GitHub Copilot to help it understand how to assist 
with code generation.

## Project Overview
The project is a demo repository for exploring various agentic AI development use cases, 
particularly in the context of BizDevOps.

### Technology Stack
- **Java 21**: JDK Version für die Anwendungsentwicklung
- **Quarkus 3.23.0**: Cloud Native Java Framework
- **Gradle**: Build-Tool für das Projekt
- **REST mit Jakarta RESTful Web Services**: REST API Entwicklung
- **Jackson**: JSON Verarbeitung für REST APIs
- **JUnit 5**: Testing-Framework
- **REST Assured**: Test-Framework für REST APIs
- **Docker**: Containerisierung der Anwendung
- **GraalVM Native Image**: Native Kompilierung (unterstützt über Quarkus)

### Code Style and Conventions
- Use clear and descriptive variable and function names.
- Follow consistent indentation and formatting styles.
- Write comments to explain complex logic or important decisions.
- Use docstrings for functions and classes to describe their purpose and usage.
- Ensure that code is modular and reusable where possible.
- Write unit tests for critical components to ensure reliability.
- Use version control best practices, including meaningful commit messages.
- Keep the codebase organized with a clear directory structure.
- Use appropriate error handling and logging mechanisms.
- Ensure that the code is compatible with the latest versions of dependencies.
- Follow security best practices, especially when handling user input or sensitive data.

### Version Control
- Use Git for version control.
- Commit changes regularly with meaningful commit messages.
- Use branches for new features or bug fixes.
- Create pull requests for code reviews of branches before merging into the main branch.
- Use descriptive branch names that reflect the feature or bug being addressed.
- Ensure that the main branch is always in a deployable state.
- Use tags to mark releases or significant milestones in the project.

### Documentation
- Maintain clear and up-to-date documentation for the project.
- Use Markdown for README files and other documentation.
- Document API endpoints, including request and response formats.
- Provide examples of how to use the APIs in the documentation.
- Include setup instructions for development and deployment environments.
- Document any third-party libraries or tools used in the project.
- Use the `docs/` directory for all project documentation, including ADRs, setup guides, and API documentation.
- Use ADRs (Architectural Decision Records) to document significant architectural decisions, located in the `docs/adr` directory.
- Use the `docs/api` directory for API documentation, including OpenAPI specifications.
- Use Arc42 for architecture documentation, located in the `docs/arc42` directory.
- Ensure that documentation is version-controlled and updated with code changes.

### Testing
- Write unit tests for all critical components.
- Use JUnit 5 for unit testing and REST Assured for API testing.
- Ensure that tests cover both positive and negative scenarios.
- Run tests regularly to ensure code quality and functionality.
- Use GitHub Actions for continuous integration to automate testing.

### Build
- Use Gradle as the build tool for the project.
- Ensure that the build process is automated and reproducible.

```shell script
# You can run your application in dev mode that enables live coding using:
./gradlew quarkusDev

# The application can be packaged using
./gradlew build
```

### Deployment
- The application can be deployed to a Kubernetes cluster.
- We use Flux as a GitOps tool for deployment.
- We use Kustomize for managing Kubernetes manifests.
- The manifests are located in the `infra/application/` directory.