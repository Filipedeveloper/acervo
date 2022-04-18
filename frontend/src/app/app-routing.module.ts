import { ListarLivrosComponent } from './views/livros/listar-livros/listar-livros.component';
import { CadastrarAutoresComponent } from './views/autores/cadastrar-autores/cadastrar-autores.component';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ListarClientesComponent } from './views/clientes/listar-clientes/listar-clientes.component';
import { ListarAutoresComponent } from './views/autores/listar-autores/listar-autores.component';
import { HomeComponent } from './views/home/home.component';

const routes: Routes = [
  {
    path: '',
    component: HomeComponent,
    data: { pageTitle: 'Página Inicial' },
  },
 {
    path: 'clientes/listar',
    component: ListarClientesComponent,
    data: { pageTitle: 'Listar Clientes' },
  },
  {
    path: 'autores/listar',
    component: ListarAutoresComponent,
    data: { pageTitle: 'Listar Autores' },
  },
  {
    path: 'autores/cadastro',
    component: CadastrarAutoresComponent,
    data: { pageTitle: 'Castro do Autor' },
  },
  {
    path: 'livros/listar',
    component: ListarLivrosComponent,
    data: { pageTitle: 'Lista de Livros' },
  },

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
