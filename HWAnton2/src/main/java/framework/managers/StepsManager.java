package framework.managers;

import framework.steps.IpotekaStep;
import framework.steps.StartStep;

public class StepsManager {

	private static StepsManager stepsManager;
	
	private StartStep sStep;
	private IpotekaStep iStep;
	
	private StepsManager() {
	}
	
	public static StepsManager getStepsManager() {
		if(stepsManager == null) {
			stepsManager = new StepsManager();
		}
		return stepsManager;
	}
	
	public StartStep getStartStep() {
		if(sStep == null) {
			sStep = new StartStep();
		}
		return sStep;
	}
	
	public IpotekaStep getIpotekaStep() {
		if(iStep == null) {
			iStep = new IpotekaStep();
		}
		return iStep;
	}
}