package com.hcl.ing.stpl.maven

import com.hcl.ing.stpl.buildingblock.BuildingBlock

class MavenPublish extends BuildingBlock implements Serializable {

    static def run(script, config) {
        BuildingBlock bb = new MavenPublish(script)
        bb.initialize(config)
        bb.run()

    }

    MavenPublish(script) {
        super(script)
        EXECUTOR_IMAGE = "maven"
    }

    @Override
    def run() {

        script.stage("Maven Publish") {
            archiveArtifacts '**/*.jar'
        }

    }
}
