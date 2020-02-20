import com.hcl.ing.stpl.Checkout
import com.hcl.ing.stpl.flow.Flow
import com.hcl.ing.stpl.maven.MavenBuild
import com.hcl.ing.stpl.maven.MavenSonarScan


def call(Map<String, String> projectConfig) {

    Flow flow = new Flow(this, 'STPL_Java')
    def config = flow.initConfig(projectConfig)

    flow.run(config) {

        Checkout.run(this, config)
        MavenBuild.run(this, config)
        MavenSonarScan.run(this, config)



    }
}

