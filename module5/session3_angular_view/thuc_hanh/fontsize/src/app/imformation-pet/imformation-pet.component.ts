import {Component, OnInit} from '@angular/core';

@Component({
  selector: 'app-imformation-pet',
  templateUrl: './imformation-pet.component.html',
  styleUrls: ['./imformation-pet.component.css']
})
export class ImformationPetComponent implements OnInit {
  petName = 'puppie';
  petImage = 'http://yourdost-blog-images.s3-ap-southeast-1.amazonaws.com/wp-content/uploads/2016/01/03165939/Dogs.jpg';

  constructor() {
  }

  ngOnInit(): void {
  }

  updateName(name) {
    this.petName = name;
  }

  updateImage(image) {
    this.petImage = image;
  }
}
