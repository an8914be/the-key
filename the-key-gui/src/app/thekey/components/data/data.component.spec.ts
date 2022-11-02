import {ComponentFixture, TestBed} from '@angular/core/testing';
import {DataComponent} from './data.component';
import {Message} from "stompjs";

const testMessage: Message = {
  command: "",
  headers: {},
  body: "{\"name\":\"john\"}",
  ack(headers?: {}): any {
  },
  nack(headers?: {}): any {
  }
};

const testMessageB: Message = {
  command: "",
  headers: {},
  body: "{\"name\":\"tim\"}",
  ack(headers?: {}): any {
  },
  nack(headers?: {}): any {
  }
};

/**
 * Test class for DataComponent
 */
describe('DataComponent', () => {
  let component: DataComponent;
  let fixture: ComponentFixture<DataComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [DataComponent]
    })
      .compileComponents();

    fixture = TestBed.createComponent(DataComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  it('should set content', () => {
    component.handleReceivedMessages(testMessage);
    expect(component.blogPostData).toEqual(JSON.parse(testMessage.body));
  });

  it('should set content once when the input content doesnt change', () => {
    spyOn(component, 'ngOnInit');

    component.handleReceivedMessages(testMessage);
    expect(component.blogPostData).toEqual(JSON.parse(testMessage.body));

    component.handleReceivedMessages(testMessage);
    expect(component.blogPostData).toEqual(JSON.parse(testMessage.body));

    expect(component.ngOnInit).toHaveBeenCalledOnceWith();
  });

  it('should update content the input content change', () => {
    spyOn(component, 'ngOnInit');

    component.handleReceivedMessages(testMessage);
    expect(component.blogPostData).toEqual(JSON.parse(testMessage.body));

    component.handleReceivedMessages(testMessageB);
    expect(component.blogPostData).toEqual(JSON.parse(testMessageB.body));

    expect(component.ngOnInit).not.toHaveBeenCalledOnceWith();
  });
});
