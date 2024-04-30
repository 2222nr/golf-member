function memberCheck(){
//    alert("선택되지 않았습니다.");
    var selectBox = document.getElementById("MemberName");
    var selectedMemberId = selectBox.value;
    var selectedMemberName = selectBox.options[selectBox.selectedIndex].text;
        // 회원 아이디를 표시할 div 요소를 가져온다.
    var memberIdDisplay = document.getElementById("memberIdDisplay");
        // 선택된 회원 아이디를 div 요소에 업데이트한다.
        memberIdDisplay.value = selectedMemberId;

    var memberId = document.getElementById("memberId");
        memberId.value = memberIdDisplay.value;
}

function selectClass(){
    var selectClass = document.getElementById("className");
    var selectClassPrice = selectClass.value;
    var selectClassName = selectClass.options[selectClass.selectedIndex].text;
    var selectedOption = selectClass.options[selectClass.selectedIndex];
    var teacherCode = selectedOption.getAttribute("data-teacher-code");
    document.getElementById("teacherCode").value = teacherCode;
    var memberId = document.getElementById("memberIdDisplay").value;
    var memberGradeData = document.getElementById("MemberName");
    var selectedOption = memberGradeData.options[memberGradeData.selectedIndex];
    var memberGrade = selectedOption.getAttribute("data-member-grade");
    var ClassTuitionDisplay = document.getElementById("ClassTuitionDisplay");
//    var tuition = document.getElementById("tuition");

//        ClassTuitionDisplay.value = selectClassPrice * 0.5;
        if(memberGrade === "VIP"){
            ClassTuitionDisplay.value = selectClassPrice * 0.5;
        }
        else{
            ClassTuitionDisplay.value = selectClassPrice;
        }
     var tuition = document.getElementById("tuition");
        tuition.value = ClassTuitionDisplay.value;

}
//
//function tuitionInput(){
//      var ClassTuitionDisplay = document.getElementById("ClassTuitionDisplay");
//      var tuition = document.getElementById("tuition");
//      tuition.value = ClassTuitionDisplay.value;
//}

function check(){
    if(document.getElementById("registMonth").value.length == 0){
            alert("수강월이 입력되지 않았습니다.")
            document.getElementById("registMonth").focus();
            return false
        }
    if(document.getElementById("MemberName").value.length == 0){
            alert("회원명이 선택되지 않았습니다.")
            document.getElementById("MemberName").focus();
            return false
        }
    if(document.getElementById("classArea").value.length == 0){
            alert("강의장소가 선택되지 않았습니다.")
            document.getElementById("classArea").focus();
            return false
        }
    if(document.getElementById("className").value.length == 0){
            alert("강의가 선택되지 않았습니다.")
            document.getElementById("className").focus();
            return false
        }
    alert("입력이 완료되었습니다.")
    document.getElementById("frm").submit()
    return true
}

function res(){
    alert("처음부터 다시 입력합니다.")
    document.getElementById("frm").reset()
    document.getElementById("registMonth").focus();

}