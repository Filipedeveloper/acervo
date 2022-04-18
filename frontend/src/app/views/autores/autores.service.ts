import ApiUrl from 'src/app/global/constant/api-urls.constant';
import { HttpClient } from '@angular/common/http';
import  Autor  from 'src/app/global/models/autor';
import { Injectable } from '@angular/core';
import { delay, tap } from 'rxjs/operators';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AutoresService {

  private readonly API = 'api/autores';
  constructor(private http: HttpClient) { }

  list(){
    return  this.http.get<Autor[]>(ApiUrl.listarAutores)
    .pipe(
      delay(5000),
      tap(autores => console.log(autores),

      )

    );
  }

  salvar(autor :Autor): Observable<Autor> {
    return this.http.post<Autor>(ApiUrl.listarAutores, autor)

  }

  atualizar(autor :Autor, id: number): Observable<Autor> {
    return this.http.put<Autor>(ApiUrl.listarAutores+ id, autor)

  }

  deletar(id: number): Observable<Autor> {
    return this.http.delete<Autor>(ApiUrl.listarAutores+ id)

  }


}
