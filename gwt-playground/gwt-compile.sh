#!/bin/bash
set -ev

java -cp ./target/classes:./src/main/java:./src/main/resources:$HOME/.m2/repository/com/google/gwt/gwt-user/2.7.0-SNAPSHOT/gwt-user-2.7.0-SNAPSHOT.jar:$HOME/.m2/repository/com/google/gwt/gwt-dev/2.7.0-SNAPSHOT/gwt-dev-2.7.0-SNAPSHOT.jar:$HOME/.m2/repository/javax/validation/validation-api/1.0.0.GA/validation-api-1.0.0.GA.jar:$HOME/.m2/repository/javax/validation/validation-api/1.0.0.GA/validation-api-1.0.0.GA-sources.jar \
    com.google.gwt.dev.Compiler -war target/gwt-sample-1.0-SNAPSHOT \
    -XnoclassMetadata -incrementalCompileWarnings -XnocheckCasts -XjsInteropMode JS -XclosureCompiler -draftCompile -gen source  \
    com.logikas.gwt.sample.gwt_sample