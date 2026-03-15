import { html, LitElement } from 'lit';
import { property } from 'lit/decorators.js';

class DemoComponent extends LitElement {

    @property()
    content: string = '';

    render() {
        return html`
      <div>
        Here could be custom content:  
         ${this.content}
      </div>
    `;
    }
}

