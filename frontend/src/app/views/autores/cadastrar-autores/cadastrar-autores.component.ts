import { AutoresService } from '../autores.service';
import { MessagemService, TipoMensagem } from './../../../core/services/messagem.service';
import  Autor  from '../../../global/models/autor'
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';


@Component({
  selector: 'app-cadastrar-autores',
  templateUrl: './cadastrar-autores.component.html',
  styleUrls: ['./cadastrar-autores.component.scss']
})
export class CadastrarAutoresComponent implements OnInit {
  email = new FormControl('', [Validators.required, Validators.email]);
  dt = new FormControl('', [Validators.required]);


  /*constructor() {

  }*/

  getErrorMessage() {
    if (this.email.hasError('required')) {
      return 'Campo obrigatório';
    }


    return this.email.hasError('email') ? 'Informe um e-mail válido' : '';
  }

  getErrorMessageDt() {
    if (this.dt.hasError('required')) {
      return 'Campo obrigatório';
    }
    return;
  }





  form: FormGroup = new FormGroup({});


  constructor(private fomrBuilder: FormBuilder, private autorService: AutoresService, private snackBar: MessagemService) {

  }

  get f(){
    return this.form.controls;
  }


  ngOnInit(): void {
    this.form = this.fomrBuilder.group({
      nome:['',[Validators.required], Validators.maxLength(50)],
      email:['',[Validators.required], Validators.email],
      dataNascimento:['',[Validators.required]],
      biografia:['',[Validators.required], Validators.maxLength(200)],
      isni:['',[Validators.required]],
    });


  }

  submit(): void{
    if(this.form.invalid){
      return;
    }

    const autor = this.form.getRawValue() as Autor;
    this.salvar(autor);
  }

  reiniciarForm(): void{
    this.form.reset();

  }

  private salvar(autor: Autor): void{
    this.autorService.salvar(autor).subscribe(() => {
      this.snackBar.open('Autor cadastrado com sucesso', TipoMensagem.SUCCESS);

    }, () =>{

      this.snackBar.open('Erro ao cadastrar Autor', TipoMensagem.ERROR)


    });
  }

  editarAutor(){

  }




}
