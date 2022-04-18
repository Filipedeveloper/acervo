import  Autor  from '../../../global/models/autor';
import { Component, OnInit, Inject } from '@angular/core';
import { AutoresService } from '../../../views/autores/autores.service';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { MessagemService, TipoMensagem } from './../../../core/services/messagem.service';


@Component({
  selector: 'app-dialog',
  templateUrl: './dialog.component.html',
  styleUrls: ['./dialog.component.scss']
})
export class DialogComponent implements OnInit {
  actionbtn: String = "Salvar";
  autorForm !: FormGroup;
  constructor(private fomrBuilder: FormBuilder,
    @Inject(MAT_DIALOG_DATA) public editar: Autor,
    private autorService: AutoresService,
    private dialogRef: MatDialogRef<DialogComponent>,

    ) { }

  ngOnInit(): void {
    this.autorForm = this.fomrBuilder.group({
      nome:['',[Validators.required]],
      email:['',[Validators.required]],
      dataNascimento:['',[Validators.required]],
      biografia:['',[Validators.required]],
      isni:['',[Validators.required]],
    });

    console.log(this.editar);
    if(this.editar){
      this.autorForm.controls['nome'].setValue(this.editar.nome);
      this.autorForm.controls['email'].setValue(this.editar.email);
      this.autorForm.controls['dataNascimento'].setValue(this.editar.dataNascimento);
      this.autorForm.controls['biografia'].setValue(this.editar.biografia);
      this.autorForm.controls['isni'].setValue(this.editar.isni);
      this.actionbtn = "Atualizar";
    }
  }

  addAutor(){

    console.log(this.autorForm.value);
   if(!this.editar){
    if(this.autorForm.valid){
      const autor = this.autorForm.getRawValue() as Autor;
      this.autorService.salvar(autor)
      .subscribe({
        next:(res)=>{
          this.autorForm.reset();

          this.dialogRef.close('save');

        },
        error:()=>{
          alert('falha');
        }
      })

    }
   }else{
     this.atualizarAutor()
   }
  }

  atualizarAutor(){
    this.autorService.atualizar(this.autorForm.value, this.editar.id)
    .subscribe({
      next:(res)=>{
        alert('deu certo');
        this.autorForm.reset();
        this.dialogRef.close('update');
      },error:()=>{
        alert('ERRROU');
      }
    })
  }



}
