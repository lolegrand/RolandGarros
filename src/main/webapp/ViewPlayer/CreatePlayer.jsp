<%
  List<Person> trainers = (List<Person>) request.getAttribute("trainers");

  String error = "";

  String errorBirthDate = "";
  String  errorBirthPlace = "";
  String errorGender = "";
  String  errorRanking = "";
  String errorBestRanking = "";
  String  errorNationality = "";
  String errorHeight = "";
  String  errorWeight = "";
  String errorStartCareer = "";
  String  errorHand = "";
  String errorTrainer = "";
  String errorCheckTrainer = "";

  if ( request.getAttribute("CreatePlayerError") != null ) {
    error = request.getAttribute("CreatePlayerError").toString();
  }

  if ( request.getAttribute("CreatePlayerError-BirthDate") != null ){
    errorBirthDate = request.getAttribute("CreatePlayerError-BirthDate").toString();
  }
  if ( request.getAttribute("CreatePlayerError-BirthPlace") != null ){
    errorBirthPlace = request.getAttribute("CreatePlayerError-BirthPlace").toString();
  }
  if ( request.getAttribute("CreatePlayerError-Gender") != null ){
    errorGender = request.getAttribute("CreatePlayerError-Gender").toString();
  }
  if ( request.getAttribute("CreatePlayerError-Ranking") != null ){
    errorRanking = request.getAttribute("CreatePlayerError-Ranking").toString();
  }
  if ( request.getAttribute("CreatePlayerError-BestRanking") != null ){
    errorBestRanking = request.getAttribute("CreatePlayerError-BestRanking").toString();
  }
  if ( request.getAttribute("CreatePlayerError-Nationality") != null ){
    errorNationality = request.getAttribute("CreatePlayerError-Nationality").toString();
  }
  if ( request.getAttribute("CreatePlayerError-Height") != null ){
    errorHeight = request.getAttribute("CreatePlayerError-Height").toString();
  }
  if ( request.getAttribute("CreatePlayerError-Weight") != null ){
    errorWeight = request.getAttribute("CreatePlayerError-Weight").toString();
  }
  if ( request.getAttribute("CreatePlayerError-StartCareer") != null ){
    errorStartCareer = request.getAttribute("CreatePlayerError-StartCareer").toString();
  }
  if ( request.getAttribute("CreatePlayerError-Hand") != null ){
    errorHand = request.getAttribute("CreatePlayerError-Hand").toString();
  }
  if ( request.getAttribute("CreatePlayerError-Trainer") != null ){
    errorTrainer = request.getAttribute("CreatePlayerError-Trainer").toString();
  }
  if ( request.getAttribute("CheckTrainer") != null ){
    errorCheckTrainer = request.getAttribute("CheckTrainer").toString();
  }

  String success = "";

  if ( request.getAttribute("CreatePlayerSuccess") != null ) {
    success = request.getAttribute("CreatePlayerSuccess").toString();
  }

  if ( trainers != null ) {
%>
<article class="w-50 row self-center space-around" id="articleCreatePlayer">
  <form class="row space-around" method="post" name="formCreatePlayer">
    <h2 class="w-100 txt-center">Nouvelle fiche joueur</h2>

    <label class="w-25">Prénom</label>
    <input required class="w-75" type="text" name="firstname" placeholder="Prénom">

    <label class="w-25">Nom</label>
    <input required class="w-75" type="text" name="lastname" placeholder="NOM">

    <div class="w-50 row space-around">
      <input required class="self-center" type="radio" name="gender" value="Male">
      <label class="self-center">Homme</label>
      <input required class="self-center" type="radio" name="gender" value="Female">
      <label class="self-center">Femme</label>
    </div>
    <p class="w-100 error"><%= errorGender %></p>

    <label class="w-25">Date de naissance</label>
    <input required class="w-25" type="date" name="birthdate">

    <p class="w-50 error"><%= errorBirthDate %></p>

    <label class="w-25">Lieu de naissance</label>
    <input required class="w-25" type="text" name="birthplace" placeholder="Lieu de naissance">

    <p class="w-50 error"><%= errorBirthPlace %></p>

    <label class="w-25">Nationalité</label>
    <input required class="w-25" type="text" name="nationality" placeholder="Nationalité">

    <p class="w-50 error"><%= errorNationality %></p>

    <label class="w-25">Taille</label>
    <input required class="w-25" type="number" min="050" max="500" name="height" placeholder="170">

    <p class="w-50 error"><%= errorHeight %></p>

    <label class="w-25">Poids</label>
    <input required class="w-25" type="number" min="0.0" max="500.0" name="weight" placeholder="65.7">

    <p class="w-50 error"><%= errorWeight %></p>

    <label class="w-25">Classement en Simple</label>
    <input required class="w-25" type="number" min="0" name="ranking" placeholder="1">

    <p class="w-50 error"><%= errorRanking %></p>

    <div class="w-75 row space-around">
      <input required class="self-center" type="radio" name="hand" value="RIGHT_HAND">
      <label class="self-center">Droitier</label>
      <input required class="self-center" type="radio" name="hand" value="LEFT_HAND">
      <label class="self-center">Gaucher</label>
      <input required class="self-center" type="radio" name="hand" value="AMBIDEXTROUS">
      <label class="self-center">Ambidextre</label>
    </div>
    <p class="w-100 error"><%= errorHand %></p>

    <label class="w-25">Début de carrière</label>
    <input required class="w-25" type="number" min="1900" max="2022" name="startCareer" placeholder="1990">

    <p class="w-50 error"><%= errorStartCareer %></p>

    <label class="w-25">Entraîneur</label>
    <select class="w-75" name="trainer">
      <% for ( Person trainer : trainers ){ %>
        <option value="<%=trainer.getId() %>">
          <%= trainer.getFirstname() %><%= trainer.getLastname() %> <%=trainer.getId()%>
        </option>
      <% } %>
    </select>
    <p class="w-100 error"><%= errorCheckTrainer %></p>
    <p class="w-100 error"><%= errorTrainer %></p>

    <input class="btn-blue w-25" type="submit" name="submitFormCreatePlayer" value="Nouveau Joueur">
  </form>


  <br>
  <p class="w-100 error"><%= success %></p>
</article>

<% } %>