google.charts.load("current", {packages:["calendar", "corechart", "bar"]});

$(function() {

	// 오늘 수확량 그리기(파이 그래프)
	var todayByGroup = getTodayCnt();
	pie(todayByGroup);
	
	// 연간 수확량 그리기 (캘린더 그래프)
	var year = getYearCnt();
	calendar(year);
	
	// 주간 수확량 그리기 (컬럼 그래프)
	var week_result = getWeekCnt();
	column(week_result);
	
	// 누적(특상/전체)
	getTotalCnt();
    
	// 시세
    getPrice();
    
    // 연간 수확량 : 연도 바꾸기
    $(document).on("change","#selectYear",function(){
    	
    	var year = getYearCnt();
    	calendar(year);
    });
    
    // 주간 수확량 : 날짜 바꾸기
    $(document).on("click","#submit",function(){
 
    	var week_result = getWeekCnt();
		column(week_result);
		
		$("#selectWeekStart").datepicker( "option", "minDate", '');
    	$("#selectWeekStart").datepicker( "option", "maxDate", '');
		
		$("#selectWeekEnd").datepicker( "option", "minDate", '');
    	$("#selectWeekEnd").datepicker( "option", "maxDate", '');
		
		
    });
    
    
    //datepicker 설정
    
    $( "#selectWeekStart" ).datepicker({
    	changeYear: true, 
    	changeMonth: true,
    	prevText: '이전달',
    	nextText: '다음달',
    	monthNames: ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'],
    	monthNamesShort: ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'],
    	dayNames: ['일','월','화','수','목','금','토'],
    	dayNamesShort: ['일','월','화','수','목','금','토'],
    	dayNamesMin: ['일','월','화','수','목','금','토'],
    	weekHeader: 'Wk',
    	dateFormat: 'yy-mm-dd',
    	showMonthAfterYear: true,
    	yearSuffix:'년'
    });
    $( "#selectWeekEnd" ).datepicker({
    	changeYear: true, 
    	changeMonth: true,
    	closeText: '닫기',
    	prevText: '이전달',
    	nextText: '다음달',
    	currentText: '오늘',
    	monthNames: ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'],
    	monthNamesShort: ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'],
    	dayNames: ['일','월','화','수','목','금','토'],
    	dayNamesShort: ['일','월','화','수','목','금','토'],
    	dayNamesMin: ['일','월','화','수','목','금','토'],
    	weekHeader: 'Wk',
    	dateFormat: 'yy-mm-dd',
    	firstDay: 0,
    	isRTL: false,
    	duration:200,
    	showAnim:'show',
    	showMonthAfterYear: true,
    	yearSuffix:'년'
    });
    
    
    $("#selectWeekStart").on("propertychange change keyup paste input", function() {
    	$("#selectWeekEnd").datepicker( "option", "minDate", $("#selectWeekStart").val());
    	$("#selectWeekEnd").datepicker( "option", "maxDate", new Date(new Date($("#selectWeekStart").val()).getTime() + 6*1000*60*60*24) );
    });
    
    $("#selectWeekEnd").on("propertychange change keyup paste input", function() {
    	$("#selectWeekStart").datepicker( "option", "minDate", new Date(new Date($("#selectWeekEnd").val()).getTime() - 6*1000*60*60*24) );
    	$("#selectWeekStart").datepicker( "option", "maxDate", $("#selectWeekEnd").val());
    });
    
});





// 숫자 3자리마다 콤마 추가
function numberWithCommas(x) {
    return x.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");
}


// ========================= 날짜 구하기 (DB에 맞는 포맷으로 변경) =========================
// =============== 오늘 날짜 ===============
function getDate(d) {
	
	var fullYear = d.getFullYear();
	var month = ("0" + (d.getMonth()+1)).slice(-2);
	var date =("0" + d.getDate()).slice(-2);
	
	return fullYear + "-" + month + "-" + date;
};

// =============== 연도(**년 1월 1일) ===============
function getYear(d) {
	var fullYear = d.getFullYear();
	
	return fullYear + "-01-01";
};



// =============== 이번주 월요일 ===============
function getWeekStart(d) {
	
	var day = d.getDay();
	var start = d.getTime() - day * 1000*60*60*24;
	
	return getDate(new Date(start));
};



//========================= 수확량 및 가격 구하기 =========================
// =============== 오늘 수확량 ===============


function getTodayCnt() {
	
	var today_G1 = 0;
	var today_G2 = 0;
	var today_G3 = 0;
	
	var today = getDate(new Date());
	
	var inputData = { 'today': today };
	
	$.ajax({
		url : "/pepper/today",
		type : "post",
		data : inputData,
		async : false,
		success : function(data) {
			
			
			// 오늘 수확량
			for (let i=0; i<data['today'].length; i++){
				if(data['today'][i]['grade'] === '1'){
					today_G1 = data['today'][i]['cnt'];
				} else if(data['today'][i]['grade'] === '2'){
					today_G2 = data['today'][i]['cnt'];
				} else if(data['today'][i]['grade'] === '3'){
					today_G3 = data['today'][i]['cnt'];
				}
			}
			
			$("#todayCnt").text(numberWithCommas(today_G1));
			$("#todayTotal").text(numberWithCommas(today_G1 + today_G2 + today_G3));
		}
	});
	
	
	var todayByGroup = [today_G1, today_G2, today_G3];
	
	return todayByGroup;
};

// =============== 누적 수확량 ===============
function getTotalCnt() {
	
	var total_G1 = 0;
	var total_G2 = 0;
	var total_G3 = 0;
	
	var year = getYear(new Date());
	
	var inputData = { 'year': year };
	
	$.ajax({
		url : "/pepper/total",
		type : "post",
		data : inputData,
		async : false,
		success : function(data) {
			
			for (let i=0; i<data['total'].length; i++){
				if(data['total'][i]['grade'] === '1'){
					total_G1 = data['total'][i]['cnt'];
				} else if(data['total'][i]['grade'] === '2'){
					total_G2 = data['total'][i]['cnt'];
				} else if(data['total'][i]['grade'] === '3'){
					total_G3 = data['total'][i]['cnt'];
				}
			}
						
			$("#totalCnt").text(numberWithCommas(total_G1));
			$("#totalTotal").text(numberWithCommas(total_G1 + total_G2 + total_G3));
		}
	});
};


// =============== 연간 수확량 ===============


function getYearCnt() {
	
	var year;
	
	var d = $("#selectYear option:selected").val();
	var startYear = d + '-01-01';
	var endYear = d + '-12-31';
	
	var inputData = { 
			'startYear': startYear,
			'endYear': endYear
			};
	
	$.ajax({
		url : "/pepper/year",
		type : "post",
		data : inputData,
		async : false,
		success : function(data) {
						
			year = data['year'];
		}
	});
	
	return year;
};


// =============== 주간 수확량 ===============


function getWeekCnt() {
	
	var start = $("#selectWeekStart").val();
	var end = $("#selectWeekEnd").val();
	
	var startDate;
	var endDate;
	
	if (start == '') {
		startDate = getWeekStart(new Date());
		endDate = getDate(new Date());
		
		$("#selectWeekStart").val(startDate);
		$("#selectWeekEnd").val(endDate);
		
	} else {
		startDate = start;
		endDate = end;
	}
	
	
	
	var week;
	var week_days = 7;
	var week_result;
//	
//	var fullyear = getYear(new Date());
	
	var inputData = { 'startDate': startDate, 'endDate': endDate };
	
	$.ajax({
		url : "/pepper/week",
		type : "post",
		data : inputData,
		async : false,
		success : function(data) {
						
			week = data['week'];
			week_result = Array(week_days).fill(null).map(() => Array());
			
			var cnt = 0;
			for (let i=0; i<week.length; i++) {

				if(week[i+1] != null){
					if (week[i]['date'] === week[i+1]['date']) {
						week_result[cnt][0] = week[i]['date'];
						week_result[cnt][week[i]['grade']] = week[i]['cnt'];
					} else {
						week_result[cnt][0] = week[i]['date'];
						week_result[cnt][week[i]['grade']] = week[i]['cnt'];
						cnt++;
					}
					
				} else {
					if (week[i-1]['date'] === week[i]['date']) {
						week_result[cnt][0] = week[i]['date'];
						week_result[cnt][week[i]['grade']] = week[i]['cnt'];
					} else {
						cnt++;
						week_result[cnt][0] = week[i]['date'];
						week_result[cnt][week[i]['grade']] = week[i]['cnt'];
						
					}
				}
			}
		}
	});
	
	return week_result;
};


// =============== 가격 ===============
function getPrice() {
	
	$.ajax({
		url : "/pepper/price",
		type : "post",
		async : false,
		success : function(data) {
			
			$("#priceDate").text(data['price'][0]+' 기준');
			$("#price").text(data['price'][1]);
		}
	});
};




//========================= 차트 그리기 =========================
function calendar(year) {
	google.charts.setOnLoadCallback(function () {
		drawCalendarChart(year);
	});
}

function pie(todayByGroup) {
	google.charts.setOnLoadCallback(function () {
		drawPieChart(todayByGroup);
	});
}

function column(week_result) {
	google.charts.setOnLoadCallback(function () {
		drawColumnChart(week_result);
	});
	
}




function drawCalendarChart(year) {
	
	var dataTable = new google.visualization.DataTable();
    
    dataTable.addColumn({ type: 'date', id: 'Date' });
    dataTable.addColumn({ type: 'number', id: 'Count_good' });
    
    for (let i=0; i<year.length; i++) {
    	 dataTable.addRows([[ new Date(year[i]['date']), year[i]['cnt']]]);
    }

    var calendar_chart = new google.visualization.Calendar(document.getElementById('calendar'));

    var options = {
        title: "연간 수확량",
        height: 250,
        noDataPattern: { // 빈 데이터 셀 색상
            backgroundColor: '#F2F2F2',
            color: '#BDBDBD'
          },
        calendar: { 
            cellSize: 20,
            cellColor: { // 셀 테두리 색상
              stroke: 'grey',
              strokeOpacity: 0.5,
              strokeWidth: 1,
            },
            underYearSpace: 10, // 연도 간격
            yearLabel: { // 연도 글씨체 설정
              fontName: 'Cafe24Dangdanghae',
              fontSize: 30,
              color: 'black',
              bold: true,
              italic: true
            },
            monthLabel: { // 월 글씨체 설정
                fontName: 'Cafe24Dangdanghae',
                fontSize: 15,
                color: 'black',
                bold: false,
                italic: false
            },
            monthOutlineColor: { // 월 테두리(데이터 있는 월)
                stroke: 'black',
                strokeOpacity: 0.8,
                strokeWidth: 2,
            },
            unusedMonthOutlineColor: { // 월 테두리(데이터 없는 월)
                stroke: 'grey',
                strokeOpacity: 0.8,
                strokeWidth: 1
            },
            underMonthSpace: 10,  // 월 간격
            dayOfWeekLabel: { // 요일 글씨체 설정
                fontName: 'Cafe24Dangdanghae',
                fontSize: 12,
                color: 'grey',
                bold: false,
                italic: true,
              },
              dayOfWeekRightSpace: 10, // 요일 간격
              daysOfWeek: '일월화수목금토', // 요일 텍스트
            }
    };

    calendar_chart.draw(dataTable, options);
}
    // ====================================== 파이 차트 ======================================
function drawPieChart(todayByGroup) {
    var data = google.visualization.arrayToDataTable([
        ['등급', '개수'],
        ['특상', todayByGroup[0]],
        ['보통', todayByGroup[1]],
        ['폐기', todayByGroup[2]]
      ]);

      var options_pie = {
        title: '오늘 수확량', // 타이틀 설정
        titleTextStyle: {
            color: 'black',
            fontName: 'Cafe24Dangdanghae',
            fontSize: 35,
            bold: false,
            italic: false,
        },
        height: 340, // 높이 설정
        chartArea: { // 차트 영역
            left: 100,
            top: 50,
            width: '100%',
            height: '100%'
        },
        legend: { // 범례 설정
            position: 'right', 
            textStyle: {
                fontName: 'Cafe24Dangdanghae',
                fontSize: 14
            }
        },
        pieSliceTextStyle: { // 차트 내 텍스트 설정
            fontName: 'Cafe24Dangdanghae',
            fontSize: 15,
            bold: false,
        },
        tooltip: { // 툴팁 설정
            textStyle: {
                color: 'black',
                fontName: 'Cafe24Dangdanghae',
                fontSize: 14
            }, 
            showColorCode: true
        },
        colors: ['#3F6ABF','#75C3F8', '#B4E7FD'],
      };

      var pie_chart = new google.visualization.PieChart(document.getElementById('pie'));

      pie_chart.draw(data, options_pie);

}


    

    // ====================================== 컬럼 차트 ======================================
function drawColumnChart(week_result) {
	
    var data_column = new google.visualization.DataTable();
    data_column.addColumn({ type: 'string', id: '날짜' });
    data_column.addColumn('number', '특상');
    data_column.addColumn('number', '보통');
    data_column.addColumn('number', '폐기');


    for(let i=0; i < week_result.length; i++) {
    	if (week_result[i][0] != null){
    		data_column.addRows([[ week_result[i][0].slice(0,10), week_result[i][1], week_result[i][2], week_result[i][3]]]);
    	}
    	
    }

      var options_column = {
        title: '주간 수확량', // 타이틀 설정
        titleTextStyle: {
            color: 'black',
            fontName: 'Cafe24Dangdanghae',
            fontSize: 35,
            bold: false,
            italic: false,
        },
        chartArea: {
        	left:200,
        	top:100,
        	width:'100%',
        	height:'100%'
        },
        tooltip: { // 툴팁 설정
        	textStyle: {
                color: 'black',
                fontName: 'Cafe24Dangdanghae',
                fontSize: 14,
            }, 
            showColorCode: true,
        },
        hAxis: { // x축 설정
        	textStyle: {
        	    color: 'black',
        	    fontName: 'Cafe24Dangdanghae',
                fontSize: 17,
        	},
        	format:'y-M-d',
        },
        vAxis: {
        	textStyle: {
    	    color: 'black',
    	    fontName: 'Cafe24Dangdanghae',
            fontSize: 17,
        	}
        },
        legend: {
        	textStyle: {
        		color: 'black',
                fontName: 'Cafe24Dangdanghae',
                fontSize: 17,
            },
        },
        colors: ['#3F6ABF','#75C3F8', '#B4E7FD'],
      };

      var column_chart = new google.charts.Bar(document.getElementById('column'));

      column_chart.draw(data_column, google.charts.Bar.convertOptions(options_column));
      
   // ====================================== 라인 차트 ======================================
      // var data_line =  new google.visualization.DataTable();
      // data_line.addColumn({ type: 'date', id: 'Date' });
      // data_line.addColumn('number', 'Good');
      // data_line.addColumn('number', 'Bad');
      // data_line.addRows([
      //     [ new Date(2020, 3, 1), 100, 20],
      //     [ new Date(2020, 4, 2), 110, 23],
      //     [ new Date(2020, 4, 3), 150, 19],
      //     [ new Date(2020, 5, 1), 100, 20],
      //     [ new Date(2020, 5, 2), 110, 23],
      //     [ new Date(2020, 5, 3), 150, 19],
      //     [ new Date(2020, 5, 4), 90, 8],
      //     [ new Date(2020, 5, 5), 95, 11]
      //   ]);

      //   var options_line = {
      //     title: '주간 수확량',
      //     titleTextStyle: {
      //         color: 'black',
      //         fontName: 'Do Hyeon',
      //         fontSize: 38,
      //         bold: false,
      //         italic: false,
      //     },
      //     curveType: 'function',
      //     legend: { position: 'bottom' },
      //     annotations: {
      //         style: 'point',
      //         textStyle: {
      //             fontName: 'Do Hyeon',
      //             fontSize: 18,
      //             bold: true,
      //             italic: true,
      //             // The color of the text.
      //             color: '#871b47',
      //             // The color of the text outline.
      //             auraColor: '#d799ae',
      //             // The transparency of the text.
      //             opacity: 0.8
      //           }
      //     },
      //     hAxis: {
      //         title: '날짜',
      //         titleTextStyle: {
      //           color: '#FF0000',
      //           fontName: 'Do Hyeon',
      //           fontSize: 15,
      //           bold: false,
      //           italic: false
      //         },
      //     },
      //     legend: {
      //         position: 'right', 
      //         textStyle: {
      //             fontName: 'Do Hyeon',
      //             fontSize: 14
      //         }
      //     },
      //     fontName: 'Do Hyeon',
      //     fontSize: 12
      //   };

      //   var chart = new google.visualization.LineChart(document.getElementById('line'));

      //   chart.draw(data_line, options_line);
};

