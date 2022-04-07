const path = require('path');
const WebpackCdnPlugin = require('webpack-cdn-plugin');
const HtmlWebpackPlugin = require('html-webpack-plugin');

const rootPath = path.resolve(__dirname, '../../../../')

config.output.publicPath = '/';

config.plugins.push(
  new HtmlWebpackPlugin({
    template: path.resolve(rootPath, 'build/processedResources/Js/main/index.html'),
    filename: path.resolve(rootPath, 'build/distributions/index.html'),
  }),
);

if (config.mode === 'production') {
  config.externals = [
    {
      react: 'React',
      'react-dom': 'ReactDOM',
    },
  ];
  config.plugins.push(
    new WebpackCdnPlugin({
      modules: [
        {
          name: 'react',
          path: 'umd/react.production.min.js',
        },
        {
          name: 'react-dom',
          path: 'umd/react-dom.production.min.js',
        },
      ],
      pathToNodeModules: path.resolve(rootPath, 'build/js'),
    }),
  );
}
