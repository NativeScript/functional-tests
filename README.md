# {N} Functional Tests 

Project with tests for all NativeScript sample apps.

Based on [NativeScript/functional-tests-core](https://github.com/NativeScript/functional-tests-core).

## Prerequisites and Environment Setup

Prerequisites and steps to setup environment are actually the same as those for [NativeScript/functional-tests-core](https://github.com/NativeScript/functional-tests-core).

Please read [this document](https://github.com/NativeScript/functional-tests-core/blob/master/docs/setup.md).

## Install Dependencies

Install [Functional Tests Core](https://github.com/NativeScript/functional-tests-core):
- Download [functional.tests.core.jar](https://github.com/NativeScript/functional-tests-core/releases)
- Place it in the `lib` folder and install it
```
mvn install:install-file -Dfile=lib/functional.tests.core-0.0.5.jar -DgroupId=functional.tests.core -DartifactId=functional.tests.core -Dversion=0.0.5 -Dpackaging=jar
```

Alternative: 

Build [Functional Tests Core](https://github.com/NativeScript/functional-tests-core) from source. Please read the [instructions](https://github.com/NativeScript/functional-tests-core#build-and-contribute).

## Run tests

**Run from command line with Maven**

Test suites and device configurations are matched in pom.xml.

Each combination of tests and device is unique configuration.

Sample entry in pom.xml:
```
        <profile>
            <id>cuteness.emu.default.api23</id>
            <properties>
                <app.config>cuteness/cuteness.emu.default.api23.properties</app.config>
                <testsuite>cuteness-android</testsuite>
            </properties>
        </profile>
```
In this case configuration ID is `cuteness.emu.default.api23`.

Here is how you can run it:
```
mvn clean test -P cuteness.emu.default.api23
```

**Run tests in Eclipse/IntelliJ IDEA**

Place this in Vm options: 
`-DappConfig=resources/config/cuteness/cuteness.emu.default.api23.properties`

## Test results

**HTML Report**
- $PROJECT_ROOT/target/surefire-reports/html/index.html

**Logs**
- Test Execution Logs: $PROJECT_ROOT/target/surefire-reports/logs/log4j.log
- Device Logs: $PROJECT_ROOT/target/surefire-reports/logs/console/*
- Screenshots: $PROJECT_ROOT/target/surefire-reports/screenshots/*
- Perf Info: $PROJECT_ROOT/target/surefire-reports/logs/perfInfo.csv