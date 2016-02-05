<html>
<head>
<title>Icecream RESTful API</title>
<link rel="stylesheet" type="text/css" href="stylesheet.css">
</head>
<body>
	<div class="wrapper">
		<div class="box">
		    <h1>Favorite IceCream RESTful Web Application!</h1>
		    <p>This is a small RESTful API that allows users to search different
			profiles by their profile names,and then receive back a JSON response
		    that displays information about that profile, including their favorite IceCream!</p>
		</div>
		<div class="box">
			<p>Click the Below Link to view all of the profiles in the 'database'. At the moment,
			there is no external database being used. All of the data has been hard-coded into the
			program.</p>
		    <a href="webapi/profiles">View All Profiles</a>
		</div>
		<div class="box">
		    <p>You can add query parameters to see all profiles that have a specific Icecream listed
		    as their favorite!</p>
		    <p><a href="webapi/profiles?icecream=vanilla">Vanilla</a></p>
		    <p><a href="webapi/profiles?icecream=chocolate">Chocolate</a></p>
		    <p><a href="webapi/profiles?icecream=strawberry">Strawberry</a></p>
	    </div>
	    <div class="box">
		    <p>This API has full CRUD functionality built in. You can see the source code by following
		    the link below to the GitHub repository. I was going to include JUnit testing, but I am still
		    working on learning how the syntax goes, and I wanted to go ahead and get this up and running.</p>
		    <p><a href="https://github.com/Ollytov/Icecream-Restful-API" target="_blank">GitHub Repository</a></p>
	    </div>
    </div>
</body>
</html>
