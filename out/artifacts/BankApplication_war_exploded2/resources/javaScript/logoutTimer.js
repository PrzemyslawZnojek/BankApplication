var time_in_minutes = 5;
var current_time = Date.parse(new Date());
var deadline = new Date(current_time + time_in_minutes*60*1000);


function time_remaining(endtime){
    var total = Date.parse(endtime) - Date.parse(new Date());
    var seconds = Math.floor( (total/1000) % 60 );
    var minutes = Math.floor( (total/1000/60) % 60 );
    return {'total':total, 'minutes':minutes, 'seconds':seconds};
}
function run_clock(id,endtime){
    var clock = document.getElementById(id);
    function update_clock(){
        var timeRemaining = time_remaining(endtime);
        clock.innerHTML = 'Timeout logout after '+timeRemaining.minutes+':'+timeRemaining.seconds;
        if(timeRemaining.total<=0){ clearInterval(timeinterval); }
    }
    update_clock(); // run function once at first to avoid delay
    var timeinterval = setInterval(update_clock,1000);
}
run_clock('clockdiv',deadline);