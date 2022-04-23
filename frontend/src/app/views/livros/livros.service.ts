import { delay, tap } from 'rxjs/operators';
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Livros } from 'src/app/global/models/livros';
import ApiUrl from 'src/app/global/constant/api-urls.constant';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class LivrosService {

  constructor(private http: HttpClient) { }

  list(){
    return  this.http.get<Livros[]>(ApiUrl.listarLivros)


  }

  salvar(livro :Livros): Observable<Livros> {
    return this.http.post<Livros>(ApiUrl.listarLivros, livro)

  }

  atualizar(livro :Livros, id: number): Observable<Livros> {
    return this.http.put<Livros>(ApiUrl.listarLivros+ id, livro)

  }

  deletar(id: number): Observable<Livros> {
    return this.http.delete<Livros>(ApiUrl.listarLivros+ id)

  }
}
