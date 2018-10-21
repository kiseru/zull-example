<!doctype html>
<html lang="ru">
<head>
  <meta charset="UTF-8">
  <meta name="viewport"
        content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <title>Zuul Example</title>
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
  <script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
  <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
</head>
<body>
<main class="container">
  <div class="mx-auto app-form-wrapper">
    <div class="bg-white rounded">
      <div class="p-3">
        <form action="/signup" method="post">
          <div class="p-1 text-center border-bottom">
            <h3>Form</h3>
          </div>

          <div class="p-3">
            <div class="form-group">
              <label for="first-name-input">First Name:</label>
              <input type="text" class="form-control" id="first-name-input" v-model="user.firstName">
            </div>
            <div class="form-group">
              <label for="last-name-input">Last Name:</label>
              <input type="text" class="form-control" id="last-name-input" v-model="user.lastName">
            </div>
          </div>

          <div class="pt-3 pb-1 text-center border-top">
            <button class="btn btn-success px-5" type="submit">Send</button>
          </div>
        </form>
      </div>
    </div>
  </div>
</main>
</body>
</html>