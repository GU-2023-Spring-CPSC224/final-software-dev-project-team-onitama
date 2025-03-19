# Really simple wrapper on Maven's command to build, test, & run your project
# Maven is a package builder and runner tool for Java
#  https://maven.apache.org/

build:
	@echo "Building Game package - results in target/ directory"
	mvn package -DskipTests

test:
	@echo "Running all tests"
	mvn test
clean:
	@echo "Cleaning Game"
	mvn clean
mvn-run:
	@echo "Running Final Game main"
	mvn exec:java

javadoc:
	@echo "Creating javadoc materials"
	@echo "These go into: target/site/apidocs/"
	@echo "Load up index.html to read them"
	-mvn javadoc:javadoc

lint:
	@echo "Running spotless linter to check source files"
	mvn spotless:check

lint-autofix:
	@echo "Autofixing linting errors"
	mvn spotless:apply
