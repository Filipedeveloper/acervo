import { Component, OnInit } from '@angular/core';
import {AfterViewInit, ViewChild} from '@angular/core';
import {MatPaginator} from '@angular/material/paginator';
import {MatTableDataSource} from '@angular/material/table';
import { Livros } from 'src/app/global/models/livros';

@Component({
  selector: 'app-listar-livros',
  templateUrl: './listar-livros.component.html',
  styleUrls: ['./listar-livros.component.scss']
})
//OnInit
export class ListarLivrosComponent implements OnInit {

  displayedColumns: string[] = ['id', 'nome', 'isbn', 'anoPublicacao', 'quantidade'];
  dataSource !: MatTableDataSource<any>;
  @ViewChild(MatPaginator) paginator!: MatPaginator;

  constructor() { }

  ELEMENT_DATA: Livros[] = [
    {id: 1, nome: "Livro 1", isbn: "1.0079", anoPublicacao: "2018", quantidade:  1,},
    {id: 2, nome: "Livro 2", isbn: "4.0026", anoPublicacao: "2018", quantidade:  2,},
    {id: 3, nome: "Livro 3", isbn: "6.941", anoPublicacao: "2018", quantidade:  3,},
    {id: 4, nome: "Livro 4", isbn: "9.0122", anoPublicacao: "2018", quantidade:  4,},
    {id: 5, nome: "Livro 5", isbn: "10.811", anoPublicacao: "2018", quantidade:  5,},
    {id: 6, nome: "Livro 6", isbn: "12.0107", anoPublicacao: "2018", quantidade:  6,},
    {id: 7, nome: "Livro 7", isbn: "14.0067", anoPublicacao: "2018", quantidade:  7,},
    {id: 8, nome: "Livro 8", isbn: "15.9994", anoPublicacao: "2018", quantidade:  8,},
    {id: 9, nome: "Livro 9", isbn: "18.9984", anoPublicacao: "2018", quantidade:  9,},
    {id: 10, nome: "Livro 10", isbn: "20.1797", anoPublicacao: "2018", quantidade:  10},
    {id: 11, nome: "Livro 11", isbn: "22.9897", anoPublicacao: "2018", quantidade:  11},
    {id: 12, nome: "Livro 12", isbn: "24.305", anoPublicacao: "2018", quantidade:  12},
    {id: 13, nome: "Livro 13", isbn: "26.9815", anoPublicacao: "2018", quantidade:  13},
    {id: 14, nome: "Livro 14", isbn: "28.0855", anoPublicacao: "2018", quantidade:  14},
    {id: 15, nome: "Livro 15", isbn: "30.9738", anoPublicacao: "2018", quantidade:  15},
    {id: 16, nome: "Livro 16", isbn: "32.065", anoPublicacao: "2018", quantidade:  16},
    {id: 17, nome: "Livro 17", isbn: "35.453", anoPublicacao: "2018", quantidade:  17},
    {id: 18, nome: "Livro 18", isbn: "39.948", anoPublicacao: "2018", quantidade:  18},
    {id: 19, nome: "Livro 19", isbn: "39.0983", anoPublicacao: "2018", quantidade:  19},
    {id: 20, nome: "Livro 20", isbn: "40.078", anoPublicacao: "2018", quantidade:  20},
  ];

  ngOnInit(): void {
    console.log('estou aqui');
    this.buscarLivros();
  }

  ngAfterViewInit() {
    this.dataSource.paginator = this.paginator;
  }
  buscarLivros(){
    this.dataSource = new MatTableDataSource(this.ELEMENT_DATA);

  }





}
