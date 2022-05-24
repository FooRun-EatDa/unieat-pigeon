var stompClient = null;

function setConnected(connected) {
  $("#connect").prop("disabled", connected);
  $("#disconnect").prop("disabled", !connected);
  if (connected) {
    $("#conversation").show();
  }
  else {
    $("#conversation").hide();
  }
  $("#greetings").html("");
}

function connect() {
  var socket = new SockJS('http://localhost:8080/pigeon/stomp');
  stompClient = Stomp.over(socket);
  stompClient.connect({}, function (frame) {
    setConnected(true);
    console.log('Connected: ' + frame);
    const senderMemberId = document.getElementById('senderMemberId').value
    stompClient.subscribe(`/user/queue/message/${senderMemberId}`, function (greeting) {
      console.log('Consume', greeting)
      showGreeting(JSON.parse(greeting.body).content);
    });
  });
}

function disconnect() {
  if (stompClient !== null) {
    stompClient.disconnect();
  }
  setConnected(false);
  console.log("Disconnected");
}

function sendMessage() {
  const senderMemberId = document.getElementById('senderMemberId').value;
  const receiverMemberId = document.getElementById('receiverMemberId').value;
  const content = document.getElementById('content').value;
  stompClient.send("/socket/message", {}, JSON.stringify({
    'senderMemberId': senderMemberId,
    'receiverMemberId': receiverMemberId,
    'content': content
  }));
}

function showGreeting(message) {
  $("#greetings").append("<tr><td>" + message + "</td></tr>");
}

$(function () {
  $("form").on('submit', function (e) {
    e.preventDefault();
  });
  $("#connect").click(function() {
    connect();
  });
  $("#disconnect").click(function() {
    disconnect();
  });
  $("#send").click(function() {
    sendMessage();
  });
});
