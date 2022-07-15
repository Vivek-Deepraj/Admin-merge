<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="/docs/4.0/assets/img/favicons/favicon.ico">

    <title>Cover Template for Bootstrap</title>

</head>

<body class="text-center">
<main role="main" class="inner cover">
    <h1 class="cover-heading">Oauth Details.</h1>
    <table class="table">
        <%-- <tr><td>Oauth</td><td>${oauth }</td></tr> --%>
        <tr>
            <td>Registrationid</td>
            <td>${registrationid }</td>
        </tr>
        <tr>
            <td>Name</td>
            <td>${Name }</td>
        </tr>
        <tr>
            <td>Authority</td>
            <td>${Authority }</td>
        </tr>
        <tr>
            <td>Authenticated</td>
            <td>${Authenticated }</td>
        </tr>
        <tr>
            <td>Credential</td>
            <td>${Credential }</td>
        </tr>
        <tr>
            <td>Details</td>
            <td>${Details }</td>
        </tr>
        <%-- <tr><td>Principal</td><td>${Principal }</td></tr>
        <tr><td>PrincipalAttr</td><td>${PrincipalAttr }</td></tr> --%>
        <tr>
            <td>Principal Auth</td>
            <td>${PrincipalAttr.authorities }</td>
        </tr>
        <tr>
            <td>Principal Details remoteAddress</td>
            <td>${PrincipalAttr.details.remoteAddress }</td>
        </tr>
        <tr>
            <td>Principal Details sessionId</td>
            <td>${PrincipalAttr.details.sessionId }</td>
        </tr>
        <tr>
            <td>Principal Details tokenValue</td>
            <td style="width:500px;">${PrincipalAttr.details.tokenValue }</td>
        </tr>
        <tr>
            <td>Principal Details tokenType</td>
            <td>${PrincipalAttr.details.tokenType }</td>
        </tr>
        <tr>
            <td>Principal User Auth</td>
            <td>${PrincipalAttr.userAuthentication }</td>
        </tr>
        <tr>
            <td>Principal oauth2Request</td>
            <td>${PrincipalAttr.oauth2Request }</td>
        </tr>
        <tr>
            <td>Principal name</td>
            <td>${PrincipalAttr.name }</td>
        </tr>
        <tr>
            <td>Principal authenticated</td>
            <td>${PrincipalAttr.authenticated }</td>
        </tr>
        <tr>
            <td>Principal clientOnly</td>
            <td>${PrincipalAttr.clientOnly }</td>
        </tr>
        <tr>
            <td>PrincipalAuth</td>
            <td>${PrincipalAuth }</td>
        </tr>
    </table>
</main>

<footer class="mastfoot mt-auto">
    <div class="inner">
        <p>Powered By <a href="https://deeprajsoftware.com/">Deepraj Software Services</a>.</p>
    </div>
</footer>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
        integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
        crossorigin="anonymous"></script>
</body>
</html>