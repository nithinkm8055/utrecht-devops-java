package com.hcl.ing.stpl.maven

import com.hcl.ing.stpl.buildingblock.BuildingBlock

class MavenSonarScan extends BuildingBlock implements Serializable{

    static def run(script, config) {
        BuildingBlock bb = new MavenBuild(script)
        bb.initialize(config)
        bb.run()

    }

    MavenSonarScan(script) {
        super(script)
        EXECUTOR_IMAGE = "maven"
    }

    @Override
    def run() {

        script.stage("Maven Sonar Scan") {
            script.withDockerContainer('maven') {
                script.sh "mvn sonar:sonar"
            }

        }

    }

}
