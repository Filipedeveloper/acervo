import { Component, OnInit } from '@angular/core';
import {AfterViewInit, ViewChild} from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import {MatPaginator} from '@angular/material/paginator';
import {MatTableDataSource} from '@angular/material/table';
import { JanelaComponent } from 'src/app/core/components/dialog/livros/janela/janela.component';
import { Livros } from 'src/app/global/models/livros';
import { LivrosService } from '../livros.service';

@Component({
  selector: 'app-listar-livros',
  templateUrl: './listar-livros.component.html',
  styleUrls: ['./listar-livros.component.scss']
})
//OnInit
export class ListarLivrosComponent implements OnInit {

  displayedColumns: string[] = ['id', 'nome', 'isbn', 'anoPublicacao', 'quantidade', 'acoes'];
  dataSource !: MatTableDataSource<any>;
  @ViewChild(MatPaginator) paginator!: MatPaginator;

  constructor(
    public dialog: MatDialog,
    private livroApi: LivrosService
    ) { }

  ELEMENT_DATA: Livros[] = [

  ];

  ngOnInit(): void {
    this.buscarLivros();
  }

  ngAfterViewInit() {
    //this.dataSource.paginator = this.paginator;
  }
  buscarLivros(){
    this.livroApi.list().subscribe({
      next:(res)=>{

        this.dataSource = new MatTableDataSource(res);
        this.dataSource.paginator = this.paginator;
        //this.dataSource.sort = this.sort;
      },
      error:(err)=>{
        alert('erro ao listar daos')
      }
    })
  }

  openDialogLivro() {
    this.dialog.open(JanelaComponent, {

    }).afterClosed().subscribe(val=>{

      if(val === 'save'){

        this.buscarLivros();
      }
    });


  }

  editarLivro(row: Livros){
    this.dialog.open(JanelaComponent, {
      width: '30%',
      data: row,

    }).afterClosed().subscribe(val=>{
      if(val === 'update'){
        this.buscarLivros();
      }
    });
  }

  deletarLivro(id: number){
    console.log(id);
    this.livroApi.deletar(id).subscribe({
      next:()=>{
        this.buscarLivros();
      },
      error:(error)=>{
        alert(error);
      }
    })
  }


}
