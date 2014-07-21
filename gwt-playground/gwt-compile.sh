#!/bin/bash
set -ev

#mvn compile gwt:compile -o -Dgwt.module=com.goodow.realtime.store.StoreProd \
#    -Dgwt.disableCastChecking=true -Dgwt.disableClassMetadata=true \
#    -Dgwt.compiler.optimizationLevel=9 -Dgwt.compiler.enableClosureCompiler=true \
#    -Dgwt.extraJvmArgs="-Xmx2048M"
# -Dgwt.draftCompile=true -Dgwt.style=DETAILED -Dgwt.compiler.compileReport=true

java -cp ./target/classes:./src/main/java:./src/main/resources:$HOME/.m2/repository/com/google/gwt/gwt-user/0.0.0/gwt-user-0.0.0.jar:$HOME/.m2/repository/com/google/gwt/gwt-dev/0.0.0/gwt-dev-0.0.0.jar:$HOME/.m2/repository/javax/validation/validation-api/1.0.0.GA/validation-api-1.0.0.GA.jar:$HOME/.m2/repository/javax/validation/validation-api/1.0.0.GA/validation-api-1.0.0.GA-sources.jar \
    com.google.gwt.dev.Compiler -war target/gwt-sample-1.0-SNAPSHOT \
    -XnoclassMetadata -incrementalCompileWarnings -XnocheckCasts -XjsInteropMode JS -XclosureCompiler -draftCompile \
    com.logikas.gwt.sample.gwt_sample

cp target/gwt-sample-1.0-SNAPSHOT/gwt_sample/gwt_sample.nocache.js bower/gwt_sample/gwt_sample.js