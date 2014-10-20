$(function() {
    $('#travelSearchBtn').click(function() {
        loadTravel(1)
    })

    function loadTravel(pageNum) {
        $.ajax({
            url : "api/travelSearch",
            data : {
                keyWord : $.trim($('#travelKeyWord').val()),
                pageNum : pageNum
            },
        }).done(
            function(data) {
                $("#travelLines").html($("#travelLineTemp").render(data.lines.items));
                console.log(data, _.range(data.lines.size));
                $("#pagination").html($("#paginationTemp").render({nums : _.range(data.lines.size)}));
        });
    }
})