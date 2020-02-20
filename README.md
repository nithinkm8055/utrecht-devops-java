**Utrecht-DevOps-Java**

This a standard pipeline for Java.
This pipeline follows all the standard and guidelines with appropriate build breakers implemented at each stage.
This is a dockerized pipeline and each stage runs isolated  in  it's own container.



**Pipeline Usage**

```
@Library(['stpl-pipeline-java']) _

def config = [:]

javaSTPL(config)

```