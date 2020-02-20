package com.hcl.ing.stpl.maven

import com.hcl.ing.stpl.buildingblock.BuildingBlock

class MavenSonarScan extends BuildingBlock implements Serializable {

    static def run(script, config) {
        BuildingBlock bb = new MavenSonarScan(script)
        bb.initialize(config)
        bb.run()

    }

    MavenSonarScan(script) {
        super(script)
        EXECUTOR_IMAGE = "maven"
    }

    /**
     * Perform sonar scan on the pipeline using maven-sonar-plugin
     * @return
     */
    @Override
    def run() {

        script.stage("Maven Sonar Scan") {
            script.withSonarQubeEnv(credentialsId: 'sonarqube-server') {
                script.withDockerContainer(EXECUTOR_IMAGE) {
                    script.sh "mvn sonar:sonar -b"
                }

            }
        }

    }

}
