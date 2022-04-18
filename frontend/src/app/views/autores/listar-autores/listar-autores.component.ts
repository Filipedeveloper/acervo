import { MatSnackBar } from '@angular/material/snack-bar';
import { MessagemService, TipoMensagem } from './../../../core/services/messagem.service';
import { Observable, of } from 'rxjs';
import { Component, OnInit, ViewChild, AfterViewInit, Inject } from '@angular/core';
import Autor from 'src/app/global/models/autor';
import { AutoresService } from '../autores.service';
import { catchError } from 'rxjs/operators';
import { MatDialog } from '@angular/material/dialog';
import { DialogComponent } from 'src/app/core/components/dialog/dialog.component';
import {MatPaginator} from '@angular/material/paginator';
import {MatSort} from '@angular/material/sort';
import {MatTableDataSource} from '@angular/material/table';
import { DataSource } from '@angular/cdk/collections';



@Component({
  selector: 'app-listar-autores',
  templateUrl: './listar-autores.component.html',
  styleUrls: ['./listar-autores.component.scss']
})
export class ListarAutoresComponent implements OnInit {

  displayedColumns: string[] = ['nome', 'isni', 'email', 'dataNascimento', 'acoes'];
  dataSource !: MatTableDataSource<any>;

  @ViewChild(MatPaginator) paginator!: MatPaginator;
  @ViewChild(MatSort) sort!: MatSort;

  autores$: Observable<Autor[]>;
  //displayedColumns = ['nome', 'isni', 'email', 'dataNascimento', 'acoes'];



  constructor(private autorApi: AutoresService,

    public dialog: MatDialog,
    private snackBar: MessagemService
    ) {

    this.autores$ = this.autorApi.list()
    .pipe(
      catchError(error => {
        console.log(error);
        this.onError('Error tentar carregar as informações');
        return of([])
      }),
    );


   }

   openDialog() {
    this.dialog.open(DialogComponent, {
      width: '30%'
    }).afterClosed().subscribe(val=>{
      console.log(val);
      if(val === 'save'){
        console.log('estou aqui');
        this.buscarAutores();
      }
    });


  }

  buscarAutores(){
    this.autorApi.list().subscribe({
      next:(res)=>{

        this.dataSource = new MatTableDataSource(res);
        this.dataSource.paginator = this.paginator;
        this.dataSource.sort = this.sort;


      },
      error:(err)=>{
        alert('erro ao listar ddos')
      }
    })
  }



  applyFilter(event: Event) {
    const filterValue = (event.target as HTMLInputElement).value;
    this.dataSource.filter = filterValue.trim().toLowerCase();

    if (this.dataSource.paginator) {
      this.dataSource.paginator.firstPage();
    }
  }
  editarAutor(row: Autor){
    this.dialog.open(DialogComponent, {
      width: '30%',
      data: row,

    }).afterClosed().subscribe(val=>{
      if(val === 'update'){
        this.buscarAutores();
      }
    });
  }

  deletarAutor(id: number){
    console.log(id);
    this.autorApi.deletar(id).subscribe({
      next:()=>{
        this.buscarAutores();
      },
      error:(error)=>{
        alert(error);
      }
    })

  }

   onError(errorMsg: string) {
    this.snackBar.open(errorMsg, TipoMensagem.ERROR)
  }



  ngOnInit(): void {
    this.buscarAutores();

  }



}
