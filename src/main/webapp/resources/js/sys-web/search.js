$(function() {
    $('#travelSearchBtn').click(function() {
        loadTravelTime();
        loadTravel(1);
    })

    function loadTravel(pageNum) {
        $.ajax({
            url : "api/travelSearch",
            data : {
                keyWord : $.trim($('#travelKeyWord').val()),
                pageNum : pageNum
            }
        }).done(
            function(data) {
                $("#travelLines").html($("#travelLineTemp").render(data.lines.items));
                console.log(data, _.range(data.lines.totalPages));
                $("#pagination").html($("#paginationTemp").render({nums : _.range(data.lines.totalPages)}));
        });
    }

    function loadTravelTime() {
        $.ajax({
            url : "api/travelSearch/metaData",
            data : {
                keyWord : $.trim($('#travelKeyWord').val())
            }
        }).done(function(data) {
                console.log(data);
            $("#travelTimeList").html($("#travelTimeTemp").render(_.sortBy(data.timeList, function(num){ return Number(num); })));
            $("#platformList").html($("#platformTemp").render(data.platformList));
        });
    }
})