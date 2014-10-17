$(function() {
    $('#travelSearchBtn').click(function() {

        $.ajax({
            url : "api/travelSearch",
            data: {keyWord: $('#travelKeyWord').val()},
        }).done(function(data) {
            console.log(data);
            $( "#travelLines" ).html(
                    $("#travelLineTemp").render( data.lines )
                );
        });

    })
})