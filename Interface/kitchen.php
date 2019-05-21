<?php 
$ch = curl_init();
curl_setopt($ch, CURLOPT_SSL_VERIFYPEER, false);
curl_setopt($ch, CURLOPT_RETURNTRANSFER, true);
curl_setopt($ch, CURLOPT_URL, '127.0.0.1:2323/kitchen/detail_order/order/0');
$result = curl_exec($ch);
curl_close($ch);

$obj = json_decode($result, true);
foreach ($obj as $detail) {
  
  foreach($obj as $item){
    #echo($item["jumlah"]);
    #cho("<br>");
  }
  
}

 ?>

<!DOCTYPE html>
<html>
<head>
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">
  <title>Kitchen Service</title>
  <link rel="stylesheet" href="bootstrap-4.0.0/dist/css/bootstrap.min.css">
  <script src="jquery.js"></script>
  <!-- <link rel="stylesheet" href="css/custom.css"> -->
</head>

<body>
<h1 align="center" style="padding-top: 7px; color: #0066ff"><strong><u>Kitchen Service</u></strong></h1>
<div id="myDiv" name="myDiv" title="Example Div Element" align="center" style="font-family: Helvetica; font-size: 12pt; border: 5px solid #0066ff; border-radius: 20px; padding: 10px; width: 700px; margin: auto; top: 70px; right: 0; bottom: 40px; left: 0; margin-bottom: 30px">
  <div id="subDiv1" name="subDiv1" title="Subdivision Div Element" style="padding-bottom:10px" name = <?php echo 0; ?>>
    <ul class="list-group">
      <li class="list-group-item d-flex justify-content-between align-items-center active" style="text-align: ">
        Cras justo odio
      </li>
      <?php
          $a = 0;
          foreach($obj as $item){
            #var_dump($item);
            echo('<li class="list-group-item d-flex justify-content-between align-items-center">');
            echo ('<span class="badge badge-primary badge-pill">');
            echo ($item["jumlah"]);
            echo('</span>');
            echo($item["id_makanan"]);
            echo('<div class="btn-group btn-group-toggle align-items-center" data-toggle="buttons">');
            echo('<label class="btn btn-secondary active" id = p');
            echo($item["id_dostatus"]);
            echo(' ">');
            echo('<input type="radio" class = "procc"  name="');
            echo ($item["id_dostatus"]);
            echo('" autocomplete="off" checked disabled> Process </label>');
            echo('<label class="btn btn-secondary" id = r');
            echo($item["id_dostatus"]);
            echo(' ">');
            echo('<input type="radio" class = "rdy"  name="');
            echo ($item["id_dostatus"]);
            echo('" autocomplete="off" checked> Ready </label>');
            echo('</label></div></li>');
          }
       ?>
    </ul>
    <div class="btn-group btn-group-toggle" data-toggle="buttons" style="margin-top:7px">
      <label class="btn btn-secondary active" id = "deli_stat">
        <input type="radio" name="options" id="delivery" autocomplete="off" checked>Complete
      </label>
    </div>
  </div>
</div>
<script type="text/javascript">
  jQuery.each( [ "put", "delete" ], function( i, method ) {
    jQuery[ method ] = function( url, data, callback, type ) {
      if ( jQuery.isFunction( data ) ) {
        type = type || callback;
        callback = data;
        data = undefined;
      }

      return jQuery.ajax({
        url: url,
        type: method,
        dataType: type,
        data: data,
        success: callback
      });
    };
  });

  var but_rdy = document.getElementsByClassName("rdy");
  var but_procc = document.getElementsByClassName("procc");
  var stat = new Array(but_rdy.length);
  var stat = {};
  var active = false
  var deli_stat = document.getElementById("deli_stat");
  var deliv = document.getElementById("delivery");
    deliv.addEventListener("click", function(){
  deliver();});
  deactivate_delivery();
  for (var a =0; a<but_rdy.length;a++){
    stat[but_rdy[a].getAttribute("name")] = false
  }

  console.log(stat)
  for (var a =0;a<but_rdy.length;a++){
     (function () {
        var c = a;
        but_rdy[a].addEventListener("click", function(){ready(c)});
    }());
  }
  for (var a =0;a<but_procc.length;a++){
    (function () {
        var c = a;
        but_procc[a].addEventListener("click", function(){process(c)})
    }());
  }

  function deliver(){
    var id = document.getElementById("subDiv1").getAttribute("name")
    url = "localhost"
      $.ajax({
        type: "POST",
        url: url,
        data: {
          orderId : id,
          driverId : null,
          status : "default",
          sentAt: null,
          arrivedAt: null
        },
        dataType: "application/x-www-form-urlencoded"
      });
  }
  function activate_delivery(){
    deli_stat.classList.remove("active");
    deliv.disabled = false
  }

  function deactivate_delivery(){
    
    deli_stat.classList.add("active");
    deliv.disabled = true
  }

  function ready(element){
      var a = element
      var element = but_rdy[element];
      var proc =  but_procc[a];
      proc.disabled = false
      element.disabled = true
      var id = element.getAttribute("name");
      var rdy = document.getElementById('r'+String(id));
      var proc = document.getElementById('p'+String(id));
      url = "http://127.0.0.1:2323/kitchen/detail_order/?id_dostatus="+id+"&detailorder_status=True"
      console.log(url)
      $.put(url, {}, function(result){
        console.log(result);
      })

      rdy.classList.add("active");
      proc.classList.remove("active");
      console.log("deliver"+String(id))
      stat[id] = true
      flag = true
      console.log(stat)
      for(var key in stat){
        if(stat[key] == false){
          flag = false
          break;
        }
      }
      if (flag){
        activate_delivery()
      }
    }
  function process(element){
      var a = element
      var element = but_procc[element];
      var proc =  but_rdy[a];
      proc.disabled = false;
      element.disabled = true;
      var id = element.getAttribute("name");
      var rdy = document.getElementById('r'+String(id));
      var proc = document.getElementById('p'+String(id));

      // const proxyurl = "https://cors-anywhere.herokuapp.com/";
      url = "http://127.0.0.1:2323/kitchen/detail_order/?id_dostatus="+id+"&detailorder_status=False"
      console.log(url)
      $.put(url, {}, function(result){
        console.log(result);
      })

      rdy.classList.remove("active");
      proc.classList.add("active");
      console.log("process")
      stat[id] = false
      deactivate_delivery()
  }


</script>
</body>
</html>