export class Partidas{

    codigo: number;
    jogadores: any;
    rodadas: any;
    vencedor: string;
    
    constructor(codigo: number, jogadores: any, rodadas: any, vencedor: string){
        this.codigo = codigo;
        this.jogadores = jogadores;
        this.rodadas = rodadas;
        this.vencedor = vencedor;
    }
}