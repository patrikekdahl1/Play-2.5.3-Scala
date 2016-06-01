function showHint(str) {
    if (str.length == 0) {
        document.getElementById("txtHint").innerHTML = "";
        return;
    } else {
        var xmlhttp = new XMLHttpRequest();
        xmlhttp.onreadystatechange = function() {
            if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {

                console.log(xmlhttp.response)

                var personObj = JSON.parse(xmlhttp.response);
                var list = '';

                var fullName = personObj.map(function(a) {
                    return a.fullName;});

                for(var i = 0; i < fullName.length; i++){
                    list+= '<hr>' + '<li>' + fullName[i] + '</li>';
                }
                document.getElementById("txtHint").innerHTML = list;
            }
        };
        xmlhttp.open("GET", "?name=" + str, true);
        xmlhttp.send();
    }
}