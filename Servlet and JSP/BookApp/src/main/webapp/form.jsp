<!DOC TYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Add Book</title>
</head>
<body>
    <form action="book" method="POST">
        <label>Book Name:</label><input type="text" name="name" required/><br />
        <label>Author:</label><input type="text" name="author" required/><br />
        <label>Genre:</label><input type="text" name="genre" required/><br />
        <input type="submit" value="Submit" />
    </form>
</body>
</html>