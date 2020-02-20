package com.hcl.ing.stpl.flow

class Flow implements Serializable {

    public def script
    public def id
    public def config

    Flow(aScript, aId) {
        script = aScript
        id = aId
    }

    def run(Closure body) {

        script.ansiColor('xterm') {
            script.node('docker') {
                try {
                    script.deleteDir()
                    body()
                } catch (err) {
                    handleBuildingBlockException(err)
                } finally {
                    //yet to be implemented
                }
            }
        }

    }

    def initConfig(projectConfig) {
        config = [:]
        if (projectConfig) {
            config << projectConfig
        }
        applyDefaults()
        validateConfig()
        return config
    }


    def applyDefaults() {

    }


    def validateConfig() {

    }


    def handleBuildingBlockException(err) {
        config.buildError = "${err}" // to be used for notification
        script.echo "Error : ${err}"
        script.currentBuild.result = 'FAILURE'
    }
}