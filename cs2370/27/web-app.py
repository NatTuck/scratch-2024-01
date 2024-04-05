from http.server import HTTPServer, BaseHTTPRequestHandler

class Page:
    def __init__(self, query={}):
        self.query = query
    
    def html(self):
        return f'''
        <!doctype html>
        <html>
          <head>
            <title>{self.title}</title>
          </head>
          <body>
            <h1>{self.title}</h1>
            {self.body()}
          </body>
        </html>
        '''

    def bytes(self):
        return self.html().encode('utf-8')

    def body(self):
        return self.body

class Welcome(Page):
    title = "Welcome!"
    body = '''
    <p>Welcome to our website!</p>
    <p>We have <a href="/page2">another page</a>.</p>
    <form action="/handle_form">
    <p>What is your favorite color? 
      <input type="text" name="best">
    </p>
    <p>What's your least favorite color?
      <input type="text" name="worst">
    </p>
    <p><button>Submit</button></p>
    </form>
    '''

class Page2(Page):
    title = "Page 2"
    body = '''
    <p>Welcome to page 2</p>
    <p>Back to the<a href="/">welcome page</a>.</p>
    '''

class HandleForm(Page):
    title = "Form Submitted"
    def body(self):
        return f'''
        <p>You submitted a form.</p>
        <p>Data = {str(self.query)}</p>
        '''


class Handler(BaseHTTPRequestHandler):
    routes = {
        '/': Welcome,
        '/page2': Page2,
        '/handle_form': HandleForm,
    }
    
    def do_GET(self):
        (path, query) = self.parse_path()
        print("path=", path, "; query=" , query)
   
        if not path in self.routes:
            self.send_response(404)
            self.end_headers()
            self.wfile.write(b"404 not found")
            return
        
        self.send_response(200)
        self.end_headers()

        page = self.routes[path](query)
        self.wfile.write(page.bytes())


    def parse_path(self):
        if "?" in self.path:
            path, q_text = self.path.split('?')
            query = {}
            print(q_text)
            for pair in q_text.split('&'):
                print(pair)
                (key, val) = pair.split('=')
                query[key] = val
                return (path, query)
        else:
            return (self.path, {})


    def do_POST(self):
        if not self.path in self.post_routes:
            self.send_response(404)
            self.end_headers()
            self.wfile.write(b"404 not found")
            return

        print("Got post to " + self.path)
        print(self.get_post_data())
        
        self.send_response(200)
        self.end_headers()
        page = self.post_routes[self.path]()
        self.wfile.write(page.bytes())
        pass

    def get_post_data(self):
        data = self.rfile.read()
        return data


if __name__ == '__main__':
    server = HTTPServer(('', 4040), Handler)
    server.serve_forever()
