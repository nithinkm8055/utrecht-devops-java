package com.hcl.ing.stpl

import com.hcl.ing.stpl.buildingblock.BuildingBlock

class Checkout extends BuildingBlock implements Serializable{

    static def run(script, config, staged = true) {
        BuildingBlock bb = new Checkout(script)
        bb.initialize(config)
        bb.run()

    }

    Checkout(script) {
        super(script)
    }

    def run() {

        script.stage("Checkout") {
            script.echo "Checkout"
            //script.checkout script.scm
        }

    }

}
