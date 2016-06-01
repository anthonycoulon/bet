<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/rules.css"/>" />
    <script type="text/javascript">
        $(function() {
            $('.menu-item').removeClass('active');
            $('#menu-rules').addClass('active');
        })
    </script>
</head>
<body>
<div class="container-fluid">
    <h1 class="text-primary">Valtech Bet Rules</h1>
    <p class="lead">Let's play together and find the next winner of this Euro 2016 !</p>

    <h3 class="text-primary">Valtech Bet Description</h3>
    <p>The Valtech Bet site is a project for all Valtech collaborators about the Euro 2016. The aim is to bet for each game during the event.</p>

    <h3 class="text-primary">How to play?</h3>
    <p>The rules for the bet are very simple.</p>
    <p>You just have to bet on the team which has the best chances to win the game during this Euro 2016.</p>
    <p>First, go to the <a href="<c:url value="/match"/>">Matches</a> page to list the games available to bet : <a href="<c:url value="match"/>">Matches</a></p>
    <p>Then, bet for the team you think will win the game.</p>
    <p>At the right of each game you can see a victory's prevision based on the collaborator's bet. This prevision could give you more bonus points if you don't follow it (see examples at the bottom of this page).</p>

    <h3 class="text-primary">How to win? The notation.</h3>
    <p>Each winner you find gives you : <strong>1 point.</strong></p>
    <p>Each correct score you find gives you <strong>2 points.</strong></p>
    <p>If you bet for a team with a bad victory's prevision, it gives you a <strong>2 points</strong> bonus.</p>
    <p>Here it is an example: Suppose the match France - Roumanie. Assuming you bet for France as the winner, and you bet 2-1. Finally, France wins and with the correct score. You win 1 point for finding the good winner and 2 points for finding the good score.</p>
    <p>
        After the group phase, the points are multiplied. So the maximum possible points you can win by bet considering the previously example are :
        <ul>
            <li>
                In eighth finals:&nbsp;&nbsp;&nbsp;&nbsp;3pts * 2 = 6 points.
            </li>
            <li>
                In quarter finals:&nbsp;&nbsp;3pts * 3 = 9 points.
            </li>
            <li>
                In semi finals:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;3pts * 4 = 12 points.
            </li>
            <li>
                In final:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;3pts * 6 = 18 points.
            </li>
        </ul>
    </p>

    <h3 class="text-primary">The Rankings.</h3>
    <p>Consult all rankings at <a href="<c:url value="/ranking"/>">Ranking</a> page and see if you are leading the board or not!</p>

    <h3 class="text-primary">Prizes</h3>
    <p>If you finish first, you win the recognition of all Valtech players during 4 years (In fact, until the next Euro)</p>

    <blockquote class="blockquote-reverse">
        <p>The Euro 2016 is waiting for you... Keep betting with us!</p>
        <footer>Someone famous in Valtech</footer>
    </blockquote>
</div>
</body>
</html>
