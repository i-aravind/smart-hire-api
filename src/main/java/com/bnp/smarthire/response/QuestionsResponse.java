package com.bnp.smarthire.response;

public class QuestionsResponse {

	private Long questionaireDbId;

	private Long assessmentDbid;

	private Long questionId;

	private String questionDescription;

	private String option1;

	private String option2;

	private String option3;

	private String option4;

	private String answer;

	private String selected;

	public String getSelected() {
		return selected;
	}

	public void setSelected(String selected) {
		this.selected = selected;
	}

	public Long getQuestionId() {
		return questionId;
	}

	public void setQuestionId(Long questionId) {
		this.questionId = questionId;
	}

	public Long getQuestionaireDbId() {
		return questionaireDbId;
	}

	public void setQuestionaireDbId(Long questionaireDbId) {
		this.questionaireDbId = questionaireDbId;
	}

	public Long getAssessmentDbid() {
		return assessmentDbid;
	}

	public void setAssessmentDbid(Long assessmentDbid) {
		this.assessmentDbid = assessmentDbid;
	}

	public String getQuestionDescription() {
		return questionDescription;
	}

	public void setQuestionDescription(String questionDescription) {
		this.questionDescription = questionDescription;
	}

	public String getOption1() {
		return option1;
	}

	public void setOption1(String option1) {
		this.option1 = option1;
	}

	public String getOption2() {
		return option2;
	}

	public void setOption2(String option2) {
		this.option2 = option2;
	}

	public String getOption3() {
		return option3;
	}

	public void setOption3(String option3) {
		this.option3 = option3;
	}

	public String getOption4() {
		return option4;
	}

	public void setOption4(String option4) {
		this.option4 = option4;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("QuestionsResponse [questionaireDbId=");
		builder.append(questionaireDbId);
		builder.append(", assessmentDbid=");
		builder.append(assessmentDbid);
		builder.append(", questionId=");
		builder.append(questionId);
		builder.append(", questionDescription=");
		builder.append(questionDescription);
		builder.append(", option1=");
		builder.append(option1);
		builder.append(", option2=");
		builder.append(option2);
		builder.append(", option3=");
		builder.append(option3);
		builder.append(", option4=");
		builder.append(option4);
		builder.append(", answer=");
		builder.append(answer);
		builder.append(", selected=");
		builder.append(selected);
		builder.append("]");
		return builder.toString();
	}

}
