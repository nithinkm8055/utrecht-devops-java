package com.hcl.ing.stpl.maven

import com.hcl.ing.stpl.buildingblock.BuildingBlock

class MavenBuild extends BuildingBlock implements Serializable {


    static def run(script, config) {
        BuildingBlock bb = new MavenBuild(script)
        bb.initialize(config)
        bb.run()

    }

    MavenBuild(script) {
        super(script)
        EXECUTOR_IMAGE = "maven"
    }

    /**
     * Performs a local maven install
     * @return
     */
    @Override
    def run() {

        script.stage("Maven Build") {
            script.withDockerContainer('maven') {
                script.sh "mvn clean install"
            }

        }

    }


}
