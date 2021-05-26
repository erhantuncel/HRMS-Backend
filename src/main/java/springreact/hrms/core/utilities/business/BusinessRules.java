package springreact.hrms.core.utilities.business;

import springreact.hrms.core.utilities.results.Result;

public class BusinessRules {

	public static Result run(Result... logicResults) {
		for(Result logicResult : logicResults) {
			if(!logicResult.isSuccess()) {
				return logicResult;
			}
		}
		return null;
	}
}
