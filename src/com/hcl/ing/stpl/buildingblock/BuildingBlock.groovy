package com.hcl.ing.stpl.buildingblock

class BuildingBlock implements Serializable {

    public String EXECUTOR_IMAGE = ''
    public String EXECUTOR_ARGS = ''

    public def script
    public def config

    BuildingBlock(script) {
        this.script = script
    }

    def run(){

    }


    def applyDefaults() {
    }


    def validateConfig() {
    }



    def initialize(aConfig) {
        // TODO: ability to skip building block (e.g. based on config or not on main branch)
        try {
            config = aConfig
            applyDefaults()
            validateConfig()
        } catch (err) {
            script.echo "Error : $err"
        }
        return this
    }

}
