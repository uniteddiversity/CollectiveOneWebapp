package org.collectiveone.services;

import java.util.List;

import org.collectiveone.web.dto.DecisionDto;

public class DecisionDtoListRes {
	private List<DecisionDto> decisionDtos;
	private int[] resSet = {0,0,0};
	
	public List<DecisionDto> getDecisionDtos() {
		return decisionDtos;
	}
	public void setDecisionDtos(List<DecisionDto> decisionDtos) {
		this.decisionDtos = decisionDtos;
	}
	public int[] getResSet() {
		return resSet;
	}
	public void setResSet(int[] resSet) {
		this.resSet = resSet;
	}
}
