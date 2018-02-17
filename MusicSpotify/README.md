# AcademicProjects
# Spotify Muzik App

Spotify Muzik App is a Music Application in which you can search Tracks, Albums, Artists and User can access his playlist created on spotify.com

# Usage
Spotify Muzik App is for non-commercial use only.

# Installations and execution

1. Developers Spotify (Optional) :
  i. Create an account with Spotify developers
 ii. Get Client key and Secret Key

2. Install Visual Studio Code (or any IDE, which you feel convinient)

3. Clone the repository to your local system.

4. Add "API console extension" and "CORS Toggle" extensions to your browser. 

5. Open repository folder in visual studio code

6. Install angular cli : npm install -g @angular/cli (can use command prompt)

7. Open integrated terminal in visual studio code (or command line) Install dependencies:
    - Navigate to \FinalProjectwbdesign> and run "npm i --save serve-static"
    - Navigate to \spotifyupdated\muzik> and run "npm install", "npm install bootstrap --save "

8. Navigate to "\spotifyupdated\muzik" and run the command "npm start" (or) "ng serve"

9. Navigate to "FinalProjectwbdesign\Authorisation>" and run the command "node app.js"

10. Enable the extensions mentioned in point 4, go to localhost:8888/, login and explore the app :)

#-----The above documentation is enough to run and explore the app, below is the info about some functions and code used in the angular for this app-----#

# Getting a token 
 /*
 * This is the http post method used to obtain the token
 * Spotify authorizes the client id and client secret key and gives you a token to access the Spotify Web Api
 */
 getToken(){
     var params = ('grant_type=client_credentials');

     var headers = new Headers();
     headers.append( 'Authorization', 'Basic ' + this.encoded);
    
     headers.append('Content-Type' , 'application/x-www-form-urlencoded');

     return this._http.post('https://accounts.spotify.com/api/token', params , {headers : headers} )
     .map(res=> res.json());
  }

# SearchMuzik by Artist, Track, Album

/*
* This function lets you search  Artist, Track, Album on click of Respective tabs
* "type" parameter is critical in lettig the methid know whether to search for Artist or track or album
*/

searchMusic(str:String, type:any ,token:string){   //type='artist'/track/album
  
     
    console.log(this.encoded+"console logger"+type); 
    this.searchUrl = 'https://api.spotify.com/v1/search?query='+str+'&offset=0&limit=50&type='+type;
    let headers = new Headers();
    headers.append('Authorization' , 'Bearer ' + token);

    return this._http.get(this.searchUrl , {headers : headers})
    .map((res: Response) => res.json())
}


 # Get the playlist
 /*
 *  This function gets all the user's Play lists, the parameter token is the access token
 */
 
   getplaylist(token:string){ 
     
    console.log(this.encoded);
    this.searchUrl='https://api.spotify.com/v1/users/'+this.userId+'/playlists?limit=10&offset=0'; 
    let headers = new Headers();
    headers.append('Authorization' , 'Bearer ' + token);

    return this._http.get(this.searchUrl , {headers : headers})
    .map((res: Response) => res.json())
    
  }
  
# Get user's exact Play list 
/*
* Used to get details of user's selected Playlist
* Parameters: "id" - playlist id, token - access token
*/

getExactPlayList(id:any,token:string){ 
    
   console.log(this.encoded);
   this.searchUrl='https://api.spotify.com/v1/users/'+this.userId+'/playlists/'+id; 
   let headers = new Headers();
   headers.append('Authorization' , 'Bearer ' + token);

   return this._http.get(this.searchUrl , {headers : headers})
   .map((res: Response) => res.json())
 }
 
 # Get the tracks of the selected play list

getptracks(id:string ,token:string){
      console.log(id+"-------------------");
      this.searchUrl = 'https://api.spotify.com/v1/users/'+this.userId+'/playlists/'+id+'/tracks';
      let headers = new Headers();
      headers.append('Authorization' , 'Bearer ' + token);
  
      return this._http.get(this.searchUrl , {headers : headers})
      .map((res: Response) => res.json())
  
  }
  
  # Refer 
  # https://developer.spotify.com/web-api/ 
  # https://developer.spotify.com/web-api/endpoint-reference/
  
  # Code of conduct
  This project adheres to the Open Code of Conduct. By contributing, you are expected to honor this code.
  to 
