job('TimeTracker Job') { //*note:NodeJS example is Job name*
		scm { //*note: software configuration manager. jenkins will clone the repo.
			git ('git://github.com/bilalabesat/time-tracker.git') { node -> // is hudson.plugins.git.GitSCM
            node / gitConfigName('DSL User')
            node / gitConfigEmail('bilal.abesat@gemalto.com')
			}
		}
		
		triggers { //*note: how many time you want build it.
			scm('H/5 * * * *')
		}
		wrappers { // name of the maven installation (Manage Jenkins > Configure tools > NodeJS installations > name )
		maven ('maven')
		}
		
		steps { //*note: exec steps
			shell("clean package")
		}
}
