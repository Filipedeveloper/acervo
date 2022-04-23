import { MatTableDataSource } from '@angular/material/table';
import { MatSelect } from '@angular/material/select';
import { DialogComponent } from 'src/app/core/components/dialog/dialog.component';
import { LivrosService } from './../../../../../views/livros/livros.service';
import { MatDialog } from '@angular/material/dialog';
import { Component, Inject, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { Livros } from 'src/app/global/models/livros';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { AutoresService } from 'src/app/views/autores/autores.service';

import Autor from 'src/app/global/models/autor';

@Component({
  selector: 'app-janela',
  templateUrl: './janela.component.html',
  styleUrls: ['./janela.component.scss']
})
export class JanelaComponent implements OnInit {

  constructor(
    private fomrBuilder: FormBuilder,
    @Inject(MAT_DIALOG_DATA) public editar: Livros,
    private livrosService: LivrosService,
    private dialogRef: MatDialogRef<DialogComponent>,
    private autorApi: AutoresService,
  ) {}

  actionbtn: String = "Salvar";
  livroForm !: FormGroup;
  autores !: Autor[];
  autoresForm !: FormGroup;
  dataSource !: MatTableDataSource<any>;

  ngOnInit(): void {
    this.livroForm = this.fomrBuilder.group({
      nome:['',[Validators.required]],
      anoPublicacao:['',[Validators.required]],
      isbn:['',[Validators.required]],
      quantidade:['',[Validators.required]],
      editora:['',[Validators.required]],
      autorId:['',[Validators.required]],
    });


    if(this.editar){
      this.livroForm.controls['nome'].setValue(this.editar.nome);
      this.livroForm.controls['anoPublicacao'].setValue(this.editar.anoPublicacao);
      this.livroForm.controls['isbn'].setValue(this.editar.isbn);
      this.livroForm.controls['quantidade'].setValue(this.editar.quantidade);
      this.livroForm.controls['editora'].setValue(this.editar.editora);
      this.livroForm.controls['autorId'].setValue(this.editar.autorId);
      this.actionbtn = "Atualizar";


    }

    this.autorApi.list().subscribe({
      next:(res)=>{
        this.autores = res;

        //this.dataSource = new MatTableDataSource(res);
        //this.dataSource.paginator = this.paginator;
        //this.dataSource.sort = this.sort;


      },
      error:(err)=>{
        alert('erro ao listar ddos')
      }
    })
  }

  addLivros(){
   if(!this.editar){
    if(this.livroForm.valid){

      const livro = this.livroForm.getRawValue() as Livros;
      console.log('este é o livro') ;
      this.livrosService.salvar(livro)
      .subscribe({
        next:(res)=>{
          this.livroForm.reset();

          this.dialogRef.close('save');

        },
        error:()=>{
          alert('falha');
        }
      })

    }
   }else{
     this.atualizarLivro()
     console.log('Estou no else');
   }
  }

  atualizarLivro(){
    this.livrosService.atualizar(this.livroForm.value, this.editar.id)
    .subscribe({
      next:(res)=>{
        alert('deu certo');
        this.livroForm.reset();
        this.dialogRef.close('update');
      },error:()=>{
        alert('ERRROU');
      }
    })
  }

  buscarAutores(){
    this.autorApi.list().subscribe({
      next:(res)=>{

        this.dataSource = new MatTableDataSource(res);
        //this.dataSource = new MatTableDataSource(res);
        //this.dataSource.paginator = this.paginator;
        //this.dataSource.sort = this.sort;


      },
      error:(err)=>{
        alert('erro ao listar ddos')
      }
    })
  }



}
