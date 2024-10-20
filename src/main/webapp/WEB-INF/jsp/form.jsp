<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Form</title>
    <script>window.onload=function(){
    	console.log("form submitted");
    }</script>
</head>
<body>
    <h2>Submit Your Information</h2>
    <form action="${pageContext.request.contextPath}/edistrict/submitForm" method="post">
        <label for="name">Name:</label>
        <input type="text" id="name" name="name" required><br><br>

        <label for="email">Email:</label>
        <input type="email" id="email" name="email" required><br><br>


        <input type="hidden" name="keyy" value="aW0L3knv">
        <input type="hidden" name="hash" value="0daa301fd73a42ec94a821bd17692fc34a12ef6f3202daf8e9c2145b1149ce2e5184677b4dce755cdf15162384c15cf153b6590d1afc7fbcb2f56abff45f582e">
        <input type="hidden" name="salt" value="BZGZoe0QM2">
        <input type="hidden" name="txnid" value="605e4af9791927a0bab2">
        <input type="hidden" name="amount" value="30.0">
        <input type="hidden" name="productinfo" value='{"paymentParts":[{"name":"HP society for promotion of IT and E Governance codification of law department","description":"DIT Service Charge","merchantId":"6779426","value":"2.46","commission":"0"},{"name":"HP society for promotion of IT and E Governance codification of law department","description":"Revenue Department Service Charge","merchantId":"6779437","value":"20","commission":"0"},{"name":"HP society for promotion of IT and E Governance codification of law department","description":"eGovernance Service Charge","merchantId":"6779457","value":"5.74","commission":"0"},{"name":"HP society for promotion of IT and E Governance codification of law department","description":"DIT GST Charge","merchantId":"6789798","value":"0.54","commission":"0"},{"name":"HP society for promotion of IT","description":"eGovernance GST Charge","merchantId":"6789811","value":"1.26","commission":"0"}]}'>
        <input type="hidden" name="udf1" value="">
        <input type="hidden" name="udf2" value="">
        <input type="hidden" name="udf3" value="">
        <input type="hidden" name="udf4" value="">
        <input type="hidden" name="udf5" value="">
        <input type="hidden" name="udf6" value="">
        <input type="hidden" name="udf7" value="">
        <input type="hidden" name="udf8" value="">
        <input type="hidden" name="udf9" value="">
        <input type="hidden" name="udf10" value="">

        <button type="submit">Submit</button>
    </form>
</body>
</html>
