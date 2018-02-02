var path = require('path')
var webpack = require('webpack')
var glob = require('glob');
const HtmlWebpackPlugin = require('html-webpack-plugin')

var entries = getEntry('src/**/main.js', 'src');  // 入口是src目录下的所有main.js文件.

module.exports = {
  // entry: './src/main.js',
  entry: entries,
  output: {
    path: path.resolve(__dirname, '../webapp/dist'),
    publicPath: '/dist',
    filename: '[name]/build.js',
    chunkFilename: '[id].chunk.js'   //chunk生成的配置
  },
  module: {
    rules: [
      {
        test: /\.css$/,
        use: [
          'vue-style-loader',
          'css-loader'
        ],
      },
      {
        test: /\.scss$/,
        use: [
          'vue-style-loader',
          'css-loader',
          'sass-loader'
        ],
      },
      {
        test: /\.sass$/,
        use: [
          'vue-style-loader',
          'css-loader',
          'sass-loader?indentedSyntax'
        ],
      },
      {
        test: /\.vue$/,
        loader: 'vue-loader',
        options: {
          loaders: {
            // Since sass-loader (weirdly) has SCSS as its default parse mode, we map
            // the "scss" and "sass" values for the lang attribute to the right configs here.
            // other preprocessors should work out of the box, no loader config like this necessary.
            'scss': [
              'vue-style-loader',
              'css-loader',
              'sass-loader'
            ],
            'sass': [
              'vue-style-loader',
              'css-loader',
              'sass-loader?indentedSyntax'
            ]
          }
          // other vue-loader options go here
        }
      },
      {
        test: /\.js$/,
        loader: 'babel-loader',
        exclude: /node_modules/
      },
      {
        test: /\.(png|jpg|jpeg|gif|eot|ttf|woff|woff2|svg|svgz)(\?.+)?$/,
        loader: 'file-loader',
        options: {
          name: '[name].[ext]?[hash]'
        }
      }
    ]
  },
  resolve: {
    alias: {
      'vue$': 'vue/dist/vue.esm.js'
    },
    extensions: ['*', '.js', '.vue', '.json']
  },
  devServer: {
    host: 'localhost',
    port: 8010,
    contentBase: '../webapp/dist',
    proxy: {
      '/api/': {
        target: 'http://localhost:8080',
        changeOrigin: true,
        pathRewrite: {
          '^/api': ''
        }
      }
    },
    historyApiFallback: true,
    noInfo: true,
    overlay: true
  },
  performance: {
    hints: false
  },
  devtool: '#eval-source-map',
  plugins: Object.keys(entries).map(function (name) {
    return new HtmlWebpackPlugin({
      template: 'src/index.html',
      filename: name + '/index.html',
      hash: true,
      chunks: [name]
    })
  })
}

if (process.env.NODE_ENV === 'production') {
  module.exports.devtool = '#source-map'
  // http://vue-loader.vuejs.org/en/workflow/production.html
  module.exports.plugins = (module.exports.plugins || []).concat([
    new webpack.DefinePlugin({
      'process.env': {
        NODE_ENV: '"production"'
      }
    }),
    new webpack.optimize.UglifyJsPlugin({
      sourceMap: true,
      compress: {
        warnings: false
      }
    }),
    new webpack.LoaderOptionsPlugin({
      minimize: true
    })
  ])
}

function getEntry(globPath, pathDir) {
  var files = glob.sync(globPath);
  var entries = {},
    entry, dirname, basename, pathname, extname;

  for (var i = 0; i < files.length; i++) {
    entry = files[i];
    dirname = path.dirname(entry);
    // extname = path.extname(entry);
    // basename = path.basename(entry, extname);
    pathname = path.join(dirname, basename || '');
    pathname = pathDir ? pathname.replace(new RegExp('^' + pathDir), '') : pathname;
    pathname = pathname || '/main';  // 根目录就用main代替
    pathname = pathname.replace(/\\/g, '/');  // 所有反斜杠src\page1\main.js变成斜杠src/page1/main.js
    pathname = pathname.substring(1);   // 去掉第一个斜杠 /
    entries[pathname] = './' + entry;
  }
  return entries;
}
